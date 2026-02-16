package com.gitlab.milestone.service;

import com.gitlab.milestone.dto.MilestoneAnalyticsResponse;
import com.gitlab.milestone.entity.Issue;
import com.gitlab.milestone.entity.Milestone;
import com.gitlab.milestone.exception.AnalyticsDataUnavailableException;
import com.gitlab.milestone.repository.IssueRepository;
import com.gitlab.milestone.repository.MilestoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnalyticsServiceTest {

    @InjectMocks
    private AnalyticsService analyticsService;

    @Mock
    private MilestoneRepository milestoneRepository;
    @Mock
    private IssueRepository issueRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return analytics for milestone")
    void getAnalytics_success() {
        Milestone milestone = Milestone.builder().id(1L).build();
        Issue closedIssue = Issue.builder().id(1L).state("closed").build();
        Issue openIssue = Issue.builder().id(2L).state("open").build();

        when(milestoneRepository.findById(1L)).thenReturn(Optional.of(milestone));
        when(issueRepository.findByMilestone(milestone)).thenReturn(List.of(closedIssue, openIssue));

        MilestoneAnalyticsResponse response = analyticsService.getAnalytics(1L);

        assertThat(response.getMilestoneId()).isEqualTo(1L);
        assertThat(response.getCompletionRate()).isEqualTo(0.5);
    }

    @Test
    @DisplayName("Should throw if milestone not found")
    void getAnalytics_milestoneNotFound() {
        when(milestoneRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> analyticsService.getAnalytics(1L))
                .isInstanceOf(AnalyticsDataUnavailableException.class);
    }

    @Test
    @DisplayName("Should throw if no issues found")
    void getAnalytics_noIssues() {
        Milestone milestone = Milestone.builder().id(1L).build();
        when(milestoneRepository.findById(1L)).thenReturn(Optional.of(milestone));
        when(issueRepository.findByMilestone(milestone)).thenReturn(List.of());

        assertThatThrownBy(() -> analyticsService.getAnalytics(1L))
                .isInstanceOf(AnalyticsDataUnavailableException.class);
    }
}