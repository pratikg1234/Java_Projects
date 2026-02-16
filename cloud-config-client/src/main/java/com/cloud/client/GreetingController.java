package com.cloud.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GreetingController {
	@Value("${firstName}")
	private String firstName;
	@Value("${lastname}")
	private String lastname;
	
	@GetMapping("/hello")
	public String greet() {
		return "Hello, "+firstName + " "+lastname;
	}
	
}
