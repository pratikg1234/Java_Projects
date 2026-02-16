package com.gitlab.milestone.service;

import com.gitlab.milestone.dto.MilestoneResponse;
import com.gitlab.milestone.dto.MilestoneSearchResponse;
import com.gitlab.milestone.entity.Milestone;
import com.gitlab.milestone.repository.MilestoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchServiceTest {

    @InjectMocks
    private SearchService searchService;

    @Mock
    private MilestoneRepository milestoneRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return search results")
    void searchMilestones_success() {
        Milestone milestone = Milestone.builder()
                .id(1L)
                .title("Sprint 1")
                .description("desc")
                .startDate(LocalDate.of(2024, 7, 1))
                .dueDate(LocalDate.of(2024, 7, 15))
                .state("active")
                .scope("project")
                .scopeId(42L)
                .build();

        Page<Milestone> page = new PageImpl<>(List.of(milestone), PageRequest.of(0, 20), 1);

        when(milestoneRepository.findAll(any(Pageable.class))).thenReturn(page);

        MilestoneSearchResponse response = searchService.searchMilestones(null, null, null, null, 0, 20);

        assertThat(response.getResults()).hasSize(1);
        assertThat(response.getPagination().getTotalElements()).isEqualTo(1);
    }
}