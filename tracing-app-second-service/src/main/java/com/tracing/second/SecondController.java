package com.tracing.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/second")
public class SecondController {
	@Autowired
	private RestTemplate template;
	String thirdUrl="http://localhost:8083/third/goodevening";
	
	@GetMapping("/goodmorning")
	public String goodmorning() {
		String thirdResponse=template.getForObject(thirdUrl,String.class);
		return " Good morning from Second Controller ***Message from 3rd= "+thirdResponse;
	}
}
