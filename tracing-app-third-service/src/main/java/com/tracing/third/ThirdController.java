package com.tracing.third;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third")
public class ThirdController {
	@GetMapping("/goodevening")
	public String goodevening() {
		return "Good evening from 3rd controller...";
	}
}
