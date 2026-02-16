package com.jpa.examples;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_tble")//if we don't mention table name it will take class name as table name
public class Product {
	@Id  //this will marks prodCode as a column which will be mapped to prodCode PK column in the db table
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodCode;
	@Column
	private String prodName;
	@Column
	private double price;
	public Product() {
		super();
	}
	public Product(int prodCode, String prodName, double price) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.price = price;
	}
	public int getProdCode() {
		return prodCode;
	}
	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
