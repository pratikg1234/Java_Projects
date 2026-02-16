package com.cb.cons;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/consumer")
public class NamesListConsumerController {
	@Autowired
	RestTemplate template;
	
	@GetMapping("/names")
	//if server has some issues it will go to getTempNames() method
	@CircuitBreaker(name = "GetNamesBreaker",fallbackMethod = "getTempNames")
	public List<String> getNames(){
		String namesControllerProducerUrl = "http://localhost:8001/api/producer/names";
		String[] names = template.getForObject(namesControllerProducerUrl, String[].class);
		return Arrays.asList(names);
	}
	
	public List<String> getTempNames(Throwable t){
		System.out.println("FallBack Method");
		return Arrays.asList("Temp name1", "temp name 2", "temp name3", "Temp name 4");
	}
}
