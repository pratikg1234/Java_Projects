package com.spring.javaconfig.ex1;

import org.springframework.stereotype.Component;

public class EmailNotificationSender implements NotificationSender{

	public EmailNotificationSender() {
		System.out.println("Email object created...");
	}
	@Override
	public void sendNotification(String msg) {
		System.out.println("Notification sent via Email...");
		
	}

}
