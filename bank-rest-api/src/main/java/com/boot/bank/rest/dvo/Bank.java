package com.boot.bank.rest.dvo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	
	@Id
	private int actNumber;
	private String customerName;
	private double actBalance;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(int actNumber, String customerName, double actBalance) {
		super();
		this.actNumber = actNumber;
		this.customerName = customerName;
		this.actBalance = actBalance;
	}
	public int getActNumber() {
		return actNumber;
	}
	public void setActNumber(int actNumber) {
		this.actNumber = actNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getActBalance() {
		return actBalance;
	}
	public void setActBalance(double actBalance) {
		this.actBalance = actBalance;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actBalance, actNumber, customerName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Double.doubleToLongBits(actBalance) == Double.doubleToLongBits(other.actBalance)
				&& actNumber == other.actNumber && Objects.equals(customerName, other.customerName);
	}	
}
