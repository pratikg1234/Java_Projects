package com.cb.prod;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class NamesListProducerController {
	
	@GetMapping("/names")
	public List<String> getNames(){
		List<String> names = List.of("Java","React","Angular","Dotnet","Vue");
		return names;
	}
}
