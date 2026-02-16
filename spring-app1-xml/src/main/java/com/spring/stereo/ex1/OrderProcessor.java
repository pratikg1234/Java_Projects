package com.spring.stereo.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("op") //this annotation creates an object of OrderProcess
public class OrderProcessor {
	
	@Autowired  //it instructs container (ApplicationContext.ctx)
	@Qualifier("wns")
	private NotificationSender notificationSender;
	@Autowired
	@Qualifier("dc")
	private Checkout checkout;
	
	public void processOrder() {
		checkout.processPayment();
		System.out.println("Inventory Updated...");
		System.err.println("Send Message To Shipping");
		notificationSender.sendNotification(null);
	}
	public OrderProcessor() {
		super();
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
