package com.boot.jobboardlite.rest.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.boot.jobboardlite.rest.dvo.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jobboardlite.rest.dvo.Application;
import com.boot.jobboardlite.rest.repo.ApplicationRepository;
import com.boot.jobboardlite.rest.repo.JobRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    public boolean hasAlreadyApplied(String email, Long jobId) {
        return applicationRepository.existsByEmailAndJobId(email, jobId);
    }
    public Application applyForJob(Long jobId, Application application) {
//    	  if (!jobRepository.existsById(application.getJobId())) {
//              throw new IllegalArgumentException("Job ID does not exist: " + application.getJobId());
//          }
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()->
                        new IllegalArgumentException("Job ID does not exist: "+jobId)
                        );
        // ←– THIS LINE is critical
        application.setJob(job);

          //save to ApplicationRepository
        return applicationRepository.save(application);
    }

    //List all the applications for a job
    public List<Application> getApplicationForJob(Long jobId){
        if(!jobRepository.existsById(jobId)){
            throw new IllegalArgumentException("Job ID does not exist: "+jobId);
        }
        return applicationRepository.findByJobId(jobId);
    }
}

