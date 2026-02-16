package com.pratik.job_service.model;

import com.pratik.job_service.dto.ApplicationDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String company;
    private String location;

    @Column(length = 5000)
    private String description;

    private String salaryRange;

    @ElementCollection
    @CollectionTable(name = "job_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "skill")
    private List<String> requiredSkills = new ArrayList<>();

    @OneToMany(
            mappedBy = "job",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<ApplicationDto> applications = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public Job() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Job [id=" + id + ", title=" + title + ", company=" + company + ", location=" + location
                + ", description=" + description + ", salaryRange=" + salaryRange + ", requiredSkills="
                + requiredSkills + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, description, id, location, requiredSkills, salaryRange, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        return Objects.equals(company, other.company) && Objects.equals(description, other.description)
                && Objects.equals(id, other.id) && Objects.equals(location, other.location)
                && Objects.equals(requiredSkills, other.requiredSkills)
                && Objects.equals(salaryRange, other.salaryRange) && Objects.equals(title, other.title);
    }

    public Job(Long id, String title, String company, String location, String description, String salaryRange,
               List<String> requiredSkills) {
        super();
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.salaryRange = salaryRange;
        this.requiredSkills = requiredSkills;
    }

}
