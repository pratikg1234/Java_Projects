package com.spring.xml.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaCofigMain1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CircleConfig.class);
		CircleService cs = (CircleService) ctx.getBean("circleService");
		cs.drawCircle();
	}
}
