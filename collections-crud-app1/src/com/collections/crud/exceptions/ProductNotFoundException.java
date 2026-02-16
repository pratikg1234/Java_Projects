package com.collections.crud.exceptions;

public class ProductNotFoundException extends Exception{
	private int prodCode;

	public ProductNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundException(int prodCode) {
		super();
		this.prodCode = prodCode;
	}

	@Override
	public String toString() {
		return "ProductNotFoundException [prodCode=" + prodCode + "]";
	}

	
	
}
