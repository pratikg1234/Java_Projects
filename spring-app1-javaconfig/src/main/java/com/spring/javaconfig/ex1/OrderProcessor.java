package com.spring.javaconfig.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class OrderProcessor {
	
	//notificationSender & checkout are two dependencies and OrderProcessor is the consumer
	//and we are injecting dependencies using java beans mentioned in BeanConfig1.java
	private NotificationSender notificationSender;
	private Checkout checkout;
	
	public void processOrder() {//centralized method for using in main method
		checkout.processPayment();
		System.out.println("Inventory Updated...");
		System.out.println("Send Message To Shipping");
		notificationSender.sendNotification(null);
	}
	public void processPayment() {
		checkout.processPayment();
	} 
	
	public void sendNotification() {
		notificationSender.sendNotification(null);
	}
	public OrderProcessor() {
		super();
		this.notificationSender=notificationSender;
		this.checkout=checkout;
		System.out.println("Order object Created");
	}
	public OrderProcessor(NotificationSender notificationSender, Checkout checkout) {
		super();
		this.notificationSender = notificationSender;
		this.checkout = checkout;
	}
	public NotificationSender getNotificationSender() {
		return notificationSender;
	}
	public void setNotificationSender(NotificationSender notificationSender) {
		this.notificationSender = notificationSender;
	}
	public Checkout getCheckout() {
		return checkout;
	}
	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
	}
	
}
