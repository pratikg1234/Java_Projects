package com.streams;

import java.util.Objects;

public class ProductDup {
	private int prodCode;
	private String prodName;
	private int price;
	private int qoh;
	private String category;
	public ProductDup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDup(int prodCode, String prodName, int price, int qoh, String category) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.price = price;
		this.qoh = qoh;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, price, prodCode, prodName, qoh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDup other = (ProductDup) obj;
		return Objects.equals(category, other.category) && price == other.price && prodCode == other.prodCode
				&& Objects.equals(prodName, other.prodName) && qoh == other.qoh;
	}
	
	
}
