package com.gitlab.milestone.repository;

import com.gitlab.milestone.entity.Issue;
import com.gitlab.milestone.entity.Milestone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private MilestoneRepository milestoneRepository;

    @Test
    @DisplayName("Should save and count issues by milestone and state")
    void countByMilestoneAndState() {
        Milestone milestone = Milestone.builder()
                .title("Sprint 1")
                .description("desc")
                .startDate(LocalDate.of(2024, 7, 1))
                .dueDate(LocalDate.of(2024, 7, 15))
                .state("active")
                .scope("project")
                .scopeId(42L)
                .build();
        milestoneRepository.save(milestone);

        Issue issue1 = Issue.builder().title("Issue 1").state("open").milestone(milestone).weight(2).build();
        Issue issue2 = Issue.builder().title("Issue 2").state("closed").milestone(milestone).weight(3).build();
        issueRepository.save(issue1);
        issueRepository.save(issue2);

        int openCount = issueRepository.countByMilestoneAndState(milestone, "open");
        int closedCount = issueRepository.countByMilestoneAndState(milestone, "closed");
        int total = issueRepository.countByMilestone(milestone);

        assertThat(openCount).isEqualTo(1);
        assertThat(closedCount).isEqualTo(1);
        assertThat(total).isEqualTo(2);

        List<Issue> issues = issueRepository.findByMilestone(milestone);
        assertThat(issues).hasSize(2);
    }
}