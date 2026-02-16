package com.demo.esc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	RestTemplate template;
	
	@GetMapping("/message")
	public String message() {
		String msg = template.getForObject("http://GREETING-SERVICE/api/greet", String.class);
		return "Message consumed from greeting service is ===="+msg;
	}
}
