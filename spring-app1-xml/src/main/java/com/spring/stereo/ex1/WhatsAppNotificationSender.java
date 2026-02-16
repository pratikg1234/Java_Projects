package com.spring.stereo.ex1;

import org.springframework.stereotype.Component;

@Component("wns")
public class WhatsAppNotificationSender implements NotificationSender{

	public WhatsAppNotificationSender() {
		System.out.println("WhatsApp Object created...");
	}
	@Override
	public void sendNotification(String msg) {
		System.out.println("Notification sent via WhatsApp...");
		
	}

}
