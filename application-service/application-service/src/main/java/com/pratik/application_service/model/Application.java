package com.pratik.application_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	// ← plain primitive FK, not a JPA @ManyToOne
	@Column(name = "job_id", nullable = false)
	private Long jobId;

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
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Application(Long id, Long jobId, String fullName, String email) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.fullName = fullName;
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, id, jobId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Application other = (Application) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(id, other.id) && Objects.equals(jobId, other.jobId);
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", jobId=" + jobId + ", fullName=" + fullName + ", email=" + email + "]";
	}
	

    
}

