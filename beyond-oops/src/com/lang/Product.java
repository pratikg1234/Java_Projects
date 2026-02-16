package com.lang;

import java.util.Objects;

public class Product implements Comparable<Product>{
	private int prodId;
	private String prodName;
	
	public Product(int prodId, String prodName) {
		this.prodId = prodId;
		this.prodName = prodName;
	}

	public Product() {
		
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(prodId, prodName);
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
		return prodId == other.prodId && Objects.equals(prodName, other.prodName);
	}

	@Override
	public int compareTo(Product o) {
		return this.prodId -o.prodId;
//		if(this.prodId > o.prodId) {
//			return 1;
//		}
//		else if(this.prodId < o.prodId) {
//			return -1;
//		}
//		else {
//			return 0;
//		}
//		return 0;
	}
	
}
