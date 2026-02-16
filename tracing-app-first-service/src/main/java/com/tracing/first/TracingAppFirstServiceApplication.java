package com.tracing.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TracingAppFirstServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracingAppFirstServiceApplication.class, args);
	}

	@Bean
	public RestTemplate template(RestTemplateBuilder builder) {
		return builder.build();
	}
}
