package com.pratik.application_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "job-service", url  = "${job.service.url:http://localhost:8081}")
public interface JobClient {

    @GetMapping("/api/v1/jobs/{id}")
    JobDto getJobDetails(@PathVariable("id") Long id);

    @GetMapping("/api/v1/jobs/{id}/exists")
    Boolean jobExists(@PathVariable("id") Long id);

    class JobDto {
        public Long id;
        public String title;
        public String company;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
