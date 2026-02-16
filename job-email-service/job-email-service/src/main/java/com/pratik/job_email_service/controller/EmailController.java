package com.pratik.job_email_service.controller;

import com.pratik.job_email_service.dto.EmailRequest;
import com.pratik.job_email_service.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService=emailService;
    }
    @PostMapping("/sendmail")
    public ResponseEntity<Void> SendEmail(
            @Valid @RequestBody EmailRequest req
            ){
        emailService.sendConfirmationEmail(
                req.getToEmail(),
                req.getApplicantName(),
                req.getJobTitle()
        );
        return ResponseEntity.
                status(HttpStatus.ACCEPTED)
                .build();
    }
}
