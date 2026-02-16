package com.spring.data.jpa.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieMain1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig1.class);
		MovieService ps = ctx.getBean(MovieService.class);
		ps.addOrUpdateProduct(new Movie(101,"Pushpa 1",100,"Thriller"));
	}
}
