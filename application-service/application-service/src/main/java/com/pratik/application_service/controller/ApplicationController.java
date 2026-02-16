package com.pratik.application_service.controller;

import com.pratik.application_service.client.EmailClient;
import com.pratik.application_service.client.JobClient;
import com.pratik.application_service.dto.ApplicationRequest;
import com.pratik.application_service.dto.ApplicationResponse;
import com.pratik.application_service.dto.EmailRequest;
import com.pratik.application_service.model.Application;
import com.pratik.application_service.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    

    private final JobClient jobClient;

    private final EmailClient emailClient;

    @Autowired
    public ApplicationController(JobClient jobClient, EmailClient emailClient){
        this.jobClient=jobClient;
        this.emailClient=emailClient;
    }
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

     // Fetch Job details via Feign client to get the title
         JobClient.JobDto jobDto= jobClient.getJobDetails(req.getJobId());
        String jobTitle = (jobDto != null && jobDto.getTitle() != null)
                ? jobDto.getTitle()
                : "the job posting";

     // Send email
        EmailRequest emailRequest =new EmailRequest();
        emailRequest.setToEmail(app.getEmail());
        emailRequest.setApplicantName(app.getFullName());
        emailRequest.setJobTitle(jobTitle);
        emailClient.sendConfirmationEmail(emailRequest);
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
                        a.getJobId(),
                        a.getFullName(),
                        a.getEmail()
                ))
                .toList();
        return ResponseEntity.ok(resp);
    }

}

