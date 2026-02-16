package com.gitlab.milestone.repository;

import com.gitlab.milestone.entity.Milestone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MilestoneRepositoryTest {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Test
    @DisplayName("Should save and find milestone by title, scope, and scopeId")
    void findByTitleAndScopeAndScopeId() {
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

        Optional<Milestone> found = milestoneRepository.findByTitleAndScopeAndScopeId("Sprint 1", "project", 42L);

        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Sprint 1");
    }
}