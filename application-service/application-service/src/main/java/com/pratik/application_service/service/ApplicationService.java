package com.pratik.application_service.service;

import com.pratik.application_service.client.JobClient;
import com.pratik.application_service.exceptions.NoApplicationsFoundException;
import com.pratik.application_service.model.Application;
import com.pratik.application_service.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    private final JobClient jobClient;

    @Autowired
    public ApplicationService(JobClient jobClient){
        this.jobClient=jobClient;
    }
    public boolean hasAlreadyApplied(String email, Long jobId) {
        return applicationRepository.existsByEmailAndJobId(email, jobId);
    }
    public Application applyForJob(Long jobId, Application application) {
//    	  if (!jobRepository.existsById(application.getJobId())) {
//              throw new IllegalArgumentException("Job ID does not exist: " + application.getJobId());
//          }
        JobClient.JobDto jobDto = jobClient.getJobDetails(jobId);

//        // ←– THIS LINE is critical
        application.setJobId(jobDto.id);

          //save to ApplicationRepository
        return applicationRepository.save(application);
    }

    //List all the applications for a job
    public List<Application> getApplicationForJob(Long jobId){
        //verify job exists via job-service
        Boolean jobExists = jobClient.jobExists(jobId);
        if(jobExists == null || !jobExists){
            throw new IllegalArgumentException("Job ID does not exists: "+jobId);
        }
        List<Application> applications = applicationRepository.findByJobId(jobId);
        if(applications.isEmpty()){
            throw new NoApplicationsFoundException("No applications found for Job ID: "+jobId);
        }
        return  applicationRepository.findByJobId(jobId);
    }
}

