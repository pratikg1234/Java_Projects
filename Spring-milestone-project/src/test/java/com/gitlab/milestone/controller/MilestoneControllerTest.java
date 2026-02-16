package com.gitlab.milestone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.milestone.dto.*;
import com.gitlab.milestone.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MilestoneController.class)
class MilestoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MilestoneService milestoneService;
    @MockBean
    private ReleaseService releaseService;
    @MockBean
    private AnalyticsService analyticsService;
    @MockBean
    private SearchService searchService;
    @MockBean
    private CacheService cacheService;

    @Autowired
    private ObjectMapper objectMapper;

    private Authentication authentication;

    @BeforeEach
    void setUp() {
        authentication = new TestingAuthenticationToken("testuser", null);
    }

    @Nested
    @DisplayName("Create Milestone API")
    class CreateMilestone {

        @Test
        @DisplayName("Should create milestone successfully")
        void createMilestone_success() throws Exception {
            MilestoneCreateRequest request = new MilestoneCreateRequest();
            request.setTitle("Sprint 1");
            request.setDescription("First sprint");
            request.setStartDate(LocalDate.of(2024, 7, 1));
            request.setDueDate(LocalDate.of(2024, 7, 15));
            request.setScope("project");
            request.setScopeId(42L);

            MilestoneResponse response = MilestoneResponse.builder()
                    .id(1L)
                    .title("Sprint 1")
                    .description("First sprint")
                    .startDate(request.getStartDate())
                    .dueDate(request.getDueDate())
                    .state("active")
                    .scope("project")
                    .scopeId(42L)
                    .build();

            Mockito.when(milestoneService.createMilestone(any(), anyString()))
                    .thenReturn(response);

            mockMvc.perform(post("/api/v1/milestones")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
                    .principal(authentication))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(1L))
                    .andExpect(jsonPath("$.title").value("Sprint 1"));
        }

        @Test
        @DisplayName("Should return 400 for invalid input")
        void createMilestone_invalidInput() throws Exception {
            MilestoneCreateRequest request = new MilestoneCreateRequest();
            // Missing required fields

            mockMvc.perform(post("/api/v1/milestones")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
                    .principal(authentication))
                    .andExpect(status().isBadRequest());
        }
    }

    @Nested
    @DisplayName("Close Milestone API")
    class CloseMilestone {

        @Test
        @DisplayName("Should close milestone successfully")
        void closeMilestone_success() throws Exception {
            MilestoneResponse response = MilestoneResponse.builder()
                    .id(1L)
                    .title("Sprint 1")
                    .description("First sprint")
                    .startDate(LocalDate.of(2024, 7, 1))
                    .dueDate(LocalDate.of(2024, 7, 15))
                    .state("closed")
                    .scope("project")
                    .scopeId(42L)
                    .build();

            Mockito.when(milestoneService.closeMilestone(eq(1L), anyString()))
                    .thenReturn(response);

            mockMvc.perform(patch("/api/v1/milestones/1/close")
                    .principal(authentication))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.state").value("closed"));
        }
    }

    @Nested
    @DisplayName("Associate Release API")
    class AssociateRelease {

        @Test
        @DisplayName("Should associate release with milestone")
        void associateRelease_success() throws Exception {
            ReleaseAssociationRequest request = new ReleaseAssociationRequest();
            request.setMilestoneId(1L);

            ReleaseAssociationResponse response = ReleaseAssociationResponse.builder()
                    .releaseId(10L)
                    .milestoneId(1L)
                    .status("associated")
                    .build();

            Mockito.when(releaseService.associateReleaseWithMilestone(eq(10L), any(), anyString()))
                    .thenReturn(response);

            mockMvc.perform(post("/api/v1/milestones/releases/10/milestone")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
                    .principal(authentication))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.status").value("associated"));
        }
    }

    @Nested
    @DisplayName("Get Milestone Progress API")
    class GetMilestoneProgress {

        @Test
        @DisplayName("Should return milestone progress")
        void getMilestoneProgress_success() throws Exception {
            MilestoneProgressResponse response = MilestoneProgressResponse.builder()
                    .milestoneId(1L)
                    .completedIssues(5)
                    .totalIssues(10)
                    .percentComplete(50)
                    .build();

            Mockito.when(cacheService.getMilestoneProgress(eq(1L), any()))
                    .thenReturn(response);

            mockMvc.perform(get("/api/v1/milestones/1/progress"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.percentComplete").value(50));
        }
    }

    @Nested
    @DisplayName("Search Milestones API")
    class SearchMilestones {

        @Test
        @DisplayName("Should return search results")
        void searchMilestones_success() throws Exception {
            MilestoneResponse milestone = MilestoneResponse.builder()
                    .id(1L)
                    .title("Sprint 1")
                    .description("First sprint")
                    .startDate(LocalDate.of(2024, 7, 1))
                    .dueDate(LocalDate.of(2024, 7, 15))
                    .state("active")
                    .scope("project")
                    .scopeId(42L)
                    .build();
            Pagination pagination = Pagination.builder()
                    .page(0).size(20).totalElements(1).totalPages(1).build();

            MilestoneSearchResponse response = MilestoneSearchResponse.builder()
                    .results(List.of(milestone))
                    .pagination(pagination)
                    .build();

            Mockito.when(searchService.searchMilestones(any(), any(), any(), any(), anyInt(), anyInt()))
                    .thenReturn(response);

            mockMvc.perform(get("/api/v1/milestones/search")
                    .param("page", "0")
                    .param("size", "20"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.results[0].title").value("Sprint 1"));
        }
    }

    @Nested
    @DisplayName("Get Analytics API")
    class GetAnalytics {

        @Test
        @DisplayName("Should return analytics for milestone")
        void getAnalytics_success() throws Exception {
            MilestoneAnalyticsResponse response = MilestoneAnalyticsResponse.builder()
                    .milestoneId(1L)
                    .completionRate(0.8)
                    .avgCompletionTime(5.2)
                    .build();

            Mockito.when(analyticsService.getAnalytics(eq(1L)))
                    .thenReturn(response);

            mockMvc.perform(get("/api/v1/milestones/1/analytics"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.completionRate").value(0.8));
        }
    }
}