package com.tracing.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/first")
public class FirstController {
	@Autowired
	private RestTemplate template;
	
	String secondServiceUrl = "http://localhost:8082/second/goodmorning";
	
	@GetMapping("/hello")
	public String hello() {
		String responseFromSecond=template.getForObject(secondServiceUrl, String.class);
		
		return "Hello From First Controller *** Message from 2nd = "+responseFromSecond;
	}
}
