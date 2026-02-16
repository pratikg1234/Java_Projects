package com.spring.stereo.ex1;

import org.springframework.stereotype.Component;

@Component("ns")
public class EmailNotificationSender implements NotificationSender{

	public EmailNotificationSender() {
		System.out.println("Email object created...");
	}
	@Override
	public void sendNotification(String msg) {
		System.out.println("Notification sent via Email...");
		
	}

}
