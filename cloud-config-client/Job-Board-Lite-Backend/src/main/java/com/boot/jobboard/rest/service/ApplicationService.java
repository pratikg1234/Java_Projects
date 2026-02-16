package com.boot.jobboard.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jobboard.rest.dvo.Application;
import com.boot.jobboard.rest.repo.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application applyForJob(Application application) {
        return applicationRepository.save(application);
    }
}

