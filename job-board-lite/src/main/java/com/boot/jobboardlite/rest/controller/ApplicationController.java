package com.boot.jobboardlite.rest.controller;

import com.boot.jobboardlite.rest.dto.ApplicationRequest;
import com.boot.jobboardlite.rest.dto.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.jobboardlite.rest.dvo.Application;
import com.boot.jobboardlite.rest.dvo.Job;
import com.boot.jobboardlite.rest.repo.JobRepository;
import com.boot.jobboardlite.rest.service.ApplicationService;
import com.boot.jobboardlite.rest.service.EmailService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> applyForJob( @Valid @RequestBody ApplicationRequest req) {
        Application app = new Application();
        app.setFullName(req.getFullName());
        app.setEmail(req.getEmail());
    	 if (applicationService.hasAlreadyApplied(req.getEmail(), req.getJobId())) {
             return ResponseEntity.status(HttpStatus.CONFLICT)
                                  .body("You have already applied for this job with the same email.");
         }
        applicationService.applyForJob(req.getJobId(),app);
     // Get job title for email
        Job job = jobRepository.findById(req.getJobId())
                .orElse(null);
        String jobTitle = (job != null) ? job.getTitle() : "the job posting";
     // Send email
        emailService.sendConfirmationEmail(app.getEmail(), app.getFullName(), jobTitle);
        return ResponseEntity.ok("Application submitted successfully.");
    }

    /**
     * GET /jobs/{jobId}/applications
     * List all applications for a given job.
     */
    @GetMapping("/{jobId}")
    public ResponseEntity<List<ApplicationResponse>> getApplicationForJob(@PathVariable Long jobId){
        List<Application> apps = applicationService.getApplicationForJob(jobId);
        List<ApplicationResponse> resp = apps.stream()
                .map(a -> new ApplicationResponse(
                        a.getId(),
                        a.getJob().getId(),
                        a.getFullName(),
                        a.getEmail()
                ))
                .toList();
        return ResponseEntity.ok(resp);
    }

}

