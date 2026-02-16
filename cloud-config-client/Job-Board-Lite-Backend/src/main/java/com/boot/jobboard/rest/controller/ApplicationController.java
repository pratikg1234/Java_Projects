package com.boot.jobboard.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jobboard.rest.dvo.Application;
import com.boot.jobboard.rest.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<String> applyForJob(@RequestBody Application application) {
        applicationService.applyForJob(application);
        return ResponseEntity.ok("Application submitted successfully.");
    }
}

