package com.spring.javaconfig.ex1;

import org.springframework.stereotype.Component;

public class NetBankingCheckout implements Checkout {

	public NetBankingCheckout() {
		System.out.println("NetBanking Object created...");
	}
	@Override
	public void processPayment() {
		// TODO Auto-generated method stub
		System.out.println("Payment processed via Net Banking...");
	}
	
}
