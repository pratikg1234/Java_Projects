package com.gatewaybsgm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodMorningController {
	
	@GetMapping("/gm")
	public String goodmorning() {
		return "Good Morning";
	}
}
