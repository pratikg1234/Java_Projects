package com.spring.javaconfig.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.spring.javaconfig.ex1")
public class BeanConfig1 {
	@Bean
	public Checkout debitCheckout() {
		return new DebitCardCheckout();
	}
	
	@Bean
	public Checkout netbankingCheckout() {
		return new NetBankingCheckout();
	}
	@Bean
	public NotificationSender whatsappNotification() {
		return new WhatsAppNotificationSender();
	}
	@Bean
	public NotificationSender emailNotification() {
		return new EmailNotificationSender();
	}
	@Bean(name = "orderprocessor")
	public OrderProcessor op() {
		OrderProcessor op = new OrderProcessor();
		op.setCheckout(debitCheckout());
		op.setNotificationSender(emailNotification());
		return op;
	}

}
