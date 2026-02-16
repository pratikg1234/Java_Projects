package com.gitlab.milestone.service;

import com.gitlab.milestone.dto.ReleaseAssociationRequest;
import com.gitlab.milestone.dto.ReleaseAssociationResponse;
import com.gitlab.milestone.entity.Milestone;
import com.gitlab.milestone.entity.Release;
import com.gitlab.milestone.entity.User;
import com.gitlab.milestone.exception.*;
import com.gitlab.milestone.repository.MilestoneRepository;
import com.gitlab.milestone.repository.ReleaseRepository;
import com.gitlab.milestone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReleaseServiceTest {

    @InjectMocks
    private ReleaseService releaseService;

    @Mock
    private ReleaseRepository releaseRepository;
    @Mock
    private MilestoneRepository milestoneRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PermissionService permissionService;
    @Mock
    private AuditLogService auditLogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should associate release with milestone")
    void associateReleaseWithMilestone_success() {
        Release release = Release.builder().id(10L).build();
        Milestone milestone = Milestone.builder().id(1L).build();
        User user = User.builder().id(1L).username("testuser").roles(Set.of("ROLE_ADMIN")).build();

        ReleaseAssociationRequest request = new ReleaseAssociationRequest();
        request.setMilestoneId(1L);

        when(releaseRepository.findById(10L)).thenReturn(Optional.of(release));
        when(milestoneRepository.findById(1L)).thenReturn(Optional.of(milestone));
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(permissionService.canAssociateRelease(user, milestone)).thenReturn(true);
        when(releaseRepository.save(any())).thenReturn(release);

        ReleaseAssociationResponse response = releaseService.associateReleaseWithMilestone(10L, request, "testuser");

        assertThat(response.getReleaseId()).isEqualTo(10L);
        assertThat(response.getMilestoneId()).isEqualTo(1L);
        assertThat(response.getStatus()).isEqualTo("associated");
        verify(auditLogService).logReleaseAssociation(release, milestone, user);
    }

    @Test
    @DisplayName("Should throw when release not found")
    void associateReleaseWithMilestone_releaseNotFound() {
        ReleaseAssociationRequest request = new ReleaseAssociationRequest();
        request.setMilestoneId(1L);

        when(releaseRepository.findById(10L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> releaseService.associateReleaseWithMilestone(10L, request, "testuser"))
                .isInstanceOf(ReleaseNotFoundException.class);
    }

    @Test
    @DisplayName("Should throw when milestone not found")
    void associateReleaseWithMilestone_milestoneNotFound() {
        Release release = Release.builder().id(10L).build();
        ReleaseAssociationRequest request = new ReleaseAssociationRequest();
        request.setMilestoneId(1L);

        when(releaseRepository.findById(10L)).thenReturn(Optional.of(release));
        when(milestoneRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> releaseService.associateReleaseWithMilestone(10L, request, "testuser"))
                .isInstanceOf(MilestoneNotFoundException.class);
    }

    @Test
    @DisplayName("Should throw when association conflict")
    void associateReleaseWithMilestone_conflict() {
        Milestone otherMilestone = Milestone.builder().id(2L).build();
        Release release = Release.builder().id(10L).milestone(otherMilestone).build();
        Milestone milestone = Milestone.builder().id(1L).build();
        ReleaseAssociationRequest request = new ReleaseAssociationRequest();
        request.setMilestoneId(1L);

        when(releaseRepository.findById(10L)).thenReturn(Optional.of(release));
        when(milestoneRepository.findById(1L)).thenReturn(Optional.of(milestone));

        assertThatThrownBy(() -> releaseService.associateReleaseWithMilestone(10L, request, "testuser"))
                .isInstanceOf(AssociationConflictException.class);
    }
}