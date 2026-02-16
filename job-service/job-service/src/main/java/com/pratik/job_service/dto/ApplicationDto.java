package com.pratik.job_service.dto;

import com.pratik.job_service.model.Job;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "applications")
public class ApplicationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    private long jobId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @NotBlank(message = "Full Name is required")
    private String fullName;
    @NotBlank
    @Email
    private String email;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
    public ApplicationDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ApplicationDto(Long id, Job job, String fullName, String email) {
        super();
        this.id = id;
        this.job = job;
        this.fullName = fullName;
        this.email = email;
    }
    @Override
    public int hashCode() {
        return Objects.hash(email, fullName, id, job);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ApplicationDto other = (ApplicationDto) obj;
        return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
                && Objects.equals(id, other.id) && Objects.equals(job, other.job);
    }
    @Override
    public String toString() {
        return "Application [id=" + id + ", job=" + job + ", fullName=" + fullName + ", email=" + email + "]";
    }



}