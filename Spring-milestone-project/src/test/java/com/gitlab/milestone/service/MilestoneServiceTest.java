package com.gitlab.milestone.service;

import com.gitlab.milestone.dto.MilestoneCreateRequest;
import com.gitlab.milestone.dto.MilestoneResponse;
import com.gitlab.milestone.entity.Milestone;
import com.gitlab.milestone.entity.User;
import com.gitlab.milestone.exception.*;
import com.gitlab.milestone.repository.MilestoneRepository;
import com.gitlab.milestone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class MilestoneServiceTest {

    @InjectMocks
    private MilestoneService milestoneService;

    @Mock
    private MilestoneRepository milestoneRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private NotificationService notificationService;
    @Mock
    private AuditLogService auditLogService;
    @Mock
    private PermissionService permissionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create milestone successfully")
    void createMilestone_success() {
        MilestoneCreateRequest request = new MilestoneCreateRequest();
        request.setTitle("Sprint 1");
        request.setDescription("desc");
        request.setStartDate(LocalDate.of(2024, 7, 1));
        request.setDueDate(LocalDate.of(2024, 7, 15));
        request.setScope("project");
        request.setScopeId(1L);

        User user = User.builder().id(1L).username("testuser").roles(Set.of("ROLE_ADMIN")).build();

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(permissionService.canCreateMilestone(user, "project", 1L)).thenReturn(true);
        when(milestoneRepository.findByTitleAndScopeAndScopeId("Sprint 1", "project", 1L)).thenReturn(Optional.empty());
        when(milestoneRepository.save(any())).thenAnswer(invocation -> {
            Milestone m = invocation.getArgument(0);
            m.setId(1L);
            return m;
        });

        MilestoneResponse response = milestoneService.createMilestone(request, "testuser");

        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getTitle()).isEqualTo("Sprint 1");
        verify(notificationService).notifyCreation(any(), eq(user));
        verify(auditLogService).logCreation(any(), eq(user));
    }

    @Test
    @DisplayName("Should throw when user not found")
    void createMilestone_userNotFound() {
        MilestoneCreateRequest request = new MilestoneCreateRequest();
        request.setTitle("Sprint 1");
        request.setDescription("desc");
        request.setStartDate(LocalDate.of(2024, 7, 1));
        request.setDueDate(LocalDate.of(2024, 7, 15));
        request.setScope("project");
        request.setScopeId(1L);

        when(userRepository.findByUsername("nouser")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> milestoneService.createMilestone(request, "nouser"))
                .isInstanceOf(PermissionDeniedException.class);
    }

    @Test
    @DisplayName("Should throw when title is not unique")
    void createMilestone_titleNotUnique() {
        MilestoneCreateRequest request = new MilestoneCreateRequest();
        request.setTitle("Sprint 1");
        request.setDescription("desc");
        request.setStartDate(LocalDate.of(2024, 7, 1));
        request.setDueDate(LocalDate.of(2024, 7, 15));
        request.setScope("project");
        request.setScopeId(1L);

        User user = User.builder().id(1L).username("testuser").roles(Set.of("ROLE_ADMIN")).build();

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(permissionService.canCreateMilestone(user, "project", 1L)).thenReturn(true);
        when(milestoneRepository.findByTitleAndScopeAndScopeId("Sprint 1", "project", 1L))
                .thenReturn(Optional.of(new Milestone()));

        assertThatThrownBy(() -> milestoneService.createMilestone(request, "testuser"))
                .isInstanceOf(MilestoneTitleNotUniqueException.class);
    }

    @Test
    @DisplayName("Should throw when start date is after due date")
    void createMilestone_invalidDate() {
        MilestoneCreateRequest request = new MilestoneCreateRequest();
        request.setTitle("Sprint 1");
        request.setDescription("desc");
        request.setStartDate(LocalDate.of(2024, 7, 16));
        request.setDueDate(LocalDate.of(2024, 7, 15));
        request.setScope("project");
        request.setScopeId(1L);

        User user = User.builder().id(1L).username("testuser").roles(Set.of("ROLE_ADMIN")).build();

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(permissionService.canCreateMilestone(user, "project", 1L)).thenReturn(true);
        when(milestoneRepository.findByTitleAndScopeAndScopeId("Sprint 1", "project", 1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> milestoneService.createMilestone(request, "testuser"))
                .isInstanceOf(InvalidDateRangeException.class);
    }

    @Test
    @DisplayName("Should close milestone successfully")
    void closeMilestone_success() {
        Milestone milestone = Milestone.builder()
                .id(1L)
                .title("Sprint 1")
                .state("active")
                .scope("project")
                .scopeId(1L)
                .startDate(LocalDate.of(2024, 7, 1))
                .dueDate(LocalDate.of(2024, 7, 15))
                .build();
        User user = User.builder().id(1L).username("testuser").roles(Set.of("ROLE_ADMIN")).build();

        when(milestoneRepository.findById(1L)).thenReturn(Optional.of(milestone));
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(permissionService.canCloseMilestone(user, milestone)).thenReturn(true);
        when(milestoneRepository.save(any())).thenReturn(milestone);

        MilestoneResponse response = milestoneService.closeMilestone(1L, "testuser");

        assertThat(response.getState()).isEqualTo("closed");
        verify(notificationService).notifyClosure(milestone, user);
        verify(auditLogService).logClosure(milestone, user);
    }

    @Test
    @DisplayName("Should throw when milestone already closed")
    void closeMilestone_alreadyClosed() {
        Milestone milestone = Milestone.builder()
                .id(1L)
                .title("Sprint 1")
                .state("closed")
                .scope("project")
                .scopeId(1L)
                .build();

        when(milestoneRepository.findById(1L)).thenReturn(Optional.of(milestone));

        assertThatThrownBy(() -> milestoneService.closeMilestone(1L, "testuser"))
                .isInstanceOf(MilestoneAlreadyClosedException.class);
    }
}