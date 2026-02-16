package com.spring.xml.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlMain1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");//it will create a container
		CircleService cs = ctx.getBean(CircleService.class);//it will call c reference inside CircleService
		cs.drawCircle();
	}
}
