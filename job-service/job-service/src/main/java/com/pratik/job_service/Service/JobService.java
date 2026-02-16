package com.pratik.job_service.Service;

import com.pratik.job_service.Repository.JobRepository;
import com.pratik.job_service.exception.JobNotFoundException;
import com.pratik.job_service.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

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

    public boolean jobExistsById(Long id){
        return jobRepository.existsById(id);
    }
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
}


