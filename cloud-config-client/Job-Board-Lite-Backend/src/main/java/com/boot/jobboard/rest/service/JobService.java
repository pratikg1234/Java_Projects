package com.boot.jobboard.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jobboard.rest.dvo.Job;
import com.boot.jobboard.rest.exception.JobNotFoundException;
import com.boot.jobboard.rest.repo.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

//    public List<Job> searchJobs(String role) {
//        return jobRepository.findByTitleContainingIgnoreCase(role);
//    }
    
    public List<Job> searchJobs(String roleKeyword) {
        List<Job> jobs = jobRepository.findByTitleContainingIgnoreCase(roleKeyword);

        if (jobs.isEmpty()) {
            throw new JobNotFoundException("No jobs found for role: " + roleKeyword);
        }

        return jobs;
    }


    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }
}

