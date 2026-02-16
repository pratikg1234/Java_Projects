package com.gatewaybshbd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HappyBirthdayController {

	@GetMapping("/hbd")
	public String hbd() {
		return "Happy Birthday Controller";
	}
}
