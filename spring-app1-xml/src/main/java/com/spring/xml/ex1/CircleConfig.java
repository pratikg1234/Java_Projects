package com.spring.xml.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  //this annotation is optional
@Import(CircleConfig2.class)
public class CircleConfig {
	@Bean
	public Circle hollwCircle() {
		return new HollowCircle();
	}

	
	@Bean(name = "circleService")//if we dont provide name this will take cs as default 
	public CircleService cs() {
		CircleService cs = new CircleService(hollwCircle());
		return cs;
	}
}
