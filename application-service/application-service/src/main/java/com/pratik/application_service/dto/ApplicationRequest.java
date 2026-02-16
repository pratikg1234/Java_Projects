package com.pratik.application_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ApplicationRequest {
    @NotNull(message = "jobId is required")
    private Long jobId;

    @NotBlank(message = "Full Name is required")
    private String fullName;

    @NotBlank @Email(message = "Valid email is required")
    private String email;

    public ApplicationRequest() {
    }

    public ApplicationRequest(Long jobId, String fullName, String email) {
        this.jobId = jobId;
        this.fullName = fullName;
        this.email = email;
    }

    // getters & setters
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}
