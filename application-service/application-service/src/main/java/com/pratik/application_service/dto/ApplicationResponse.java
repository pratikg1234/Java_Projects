package com.pratik.application_service.dto;


public class ApplicationResponse {
    private Long id;
    private Long jobId;
    private String fullName;
    private String email;

    public ApplicationResponse() {
        // required for Jackson
    }

    public ApplicationResponse(Long id, Long jobId, String fullName, String email) {
        this.id = id;
        this.jobId = jobId;
        this.fullName = fullName;
        this.email = email;
    }

    // ✅ Add getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

