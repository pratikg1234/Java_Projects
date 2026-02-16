package com.spring.stereo.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StereoMain1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig1.class);
		
		System.out.println(ctx.getBean(OrderProcessor.class).getCheckout());
		System.out.println(ctx.getBean(OrderProcessor.class).getNotificationSender());
	}
}
