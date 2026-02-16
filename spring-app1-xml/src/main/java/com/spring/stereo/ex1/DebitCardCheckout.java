package com.spring.stereo.ex1;

import org.springframework.stereotype.Component;

@Component("dc")
public class DebitCardCheckout implements Checkout {

	public DebitCardCheckout() {
		System.out.println("Debit card object created...");
	}
	@Override
	public void processPayment() {
		// TODO Auto-generated method stub
		System.out.println("Payment processed via Debit Card...");
	}
	
}
