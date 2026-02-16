package com.pratik.application_service.client;

import com.pratik.application_service.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "job-email-service", url  = "${email.service.url:http://localhost:8083}")
public interface EmailClient {

    @PostMapping("/api/v1/emails/sendmail")
    void sendConfirmationEmail(@RequestBody EmailRequest request);

}
