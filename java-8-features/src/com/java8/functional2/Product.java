package com.java8.functional2;
import java.util.Objects;

public class Product {
	private int prodCode;
	private String prodName;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int prodCode, String prodName, double price) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [prodCode=" + prodCode + ", prodName=" + prodName + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, prodCode, prodName);
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
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && prodCode == other.prodCode
				&& Objects.equals(prodName, other.prodName);
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
