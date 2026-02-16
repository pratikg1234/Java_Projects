package com.spring.xml.ex1;

import org.springframework.context.annotation.Bean;

public class CircleConfig2 {

	@Bean 
	public Circle soliCircle() {
		return new SolidCircle();
	}
}
