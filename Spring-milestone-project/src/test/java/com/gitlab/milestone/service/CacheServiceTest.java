package com.gitlab.milestone.service;

import com.gitlab.milestone.dto.MilestoneProgressResponse;
import com.gitlab.milestone.entity.Milestone;
import com.gitlab.milestone.repository.IssueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class CacheServiceTest {

    @InjectMocks
    private CacheService cacheService;

    @Mock
    private IssueRepository issueRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return milestone progress")
    void getMilestoneProgress_success() {
        Milestone milestone = Milestone.builder().id(1L).build();

        when(issueRepository.countByMilestone(milestone)).thenReturn(10);
        when(issueRepository.countByMilestoneAndState(milestone, "closed")).thenReturn(5);

        MilestoneProgressResponse response = cacheService.getMilestoneProgress(1L, milestone);

        assertThat(response.getPercentComplete()).isEqualTo(50);
        assertThat(response.getCompletedIssues()).isEqualTo(5);
        assertThat(response.getTotalIssues()).isEqualTo(10);
    }

    @Test
    @DisplayName("Should handle zero total issues")
    void getMilestoneProgress_zeroTotal() {
        Milestone milestone = Milestone.builder().id(1L).build();

        when(issueRepository.countByMilestone(milestone)).thenReturn(0);
        when(issueRepository.countByMilestoneAndState(milestone, "closed")).thenReturn(0);

        MilestoneProgressResponse response = cacheService.getMilestoneProgress(1L, milestone);

        assertThat(response.getPercentComplete()).isEqualTo(0);
    }
}