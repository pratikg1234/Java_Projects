package com.spring.javaconfig.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig1.class);
		OrderProcessor op = (OrderProcessor) ctx.getBean("orderprocessor");
		op.processOrder();
	}
}
