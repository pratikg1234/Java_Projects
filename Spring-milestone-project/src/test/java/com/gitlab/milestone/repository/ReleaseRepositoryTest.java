package com.gitlab.milestone.repository;

import com.gitlab.milestone.entity.Milestone;
import com.gitlab.milestone.entity.Release;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ReleaseRepositoryTest {

    @Autowired
    private ReleaseRepository releaseRepository;
    @Autowired
    private MilestoneRepository milestoneRepository;

    @Test
    @DisplayName("Should save and find release by tag and milestone id")
    void findByTagAndMilestoneId() {
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

        Release release = Release.builder()
                .tag("v1.0")
                .description("First release")
                .milestone(milestone)
                .build();
        releaseRepository.save(release);

        Optional<Release> found = releaseRepository.findByTagAndMilestone_Id("v1.0", milestone.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getTag()).isEqualTo("v1.0");
    }
}