package com.spring.data.jpa.ex1;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int prodCode;
	@Column(name = "prod_name")
	private String prodName;
	@Column
	private double price;
	@Column
	private String category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int prodCode, String prodName, double price, String category) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.price = price;
		this.category = category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, price, prodCode, prodName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && prodCode == other.prodCode
				&& Objects.equals(prodName, other.prodName);
	}
	
}
