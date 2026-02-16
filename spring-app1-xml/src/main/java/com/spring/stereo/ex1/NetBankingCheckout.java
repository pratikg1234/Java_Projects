package com.spring.stereo.ex1;

import org.springframework.stereotype.Component;

@Component("nc")
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
