package com.examples.collections;

import java.util.Objects;

public class Product implements Comparable<Product>{
	private int prodCode;
	private String prodName;
	private double price;
//	private boolean eligibleForCod;
//	private boolean eligibleForOverNightDelivery;
	public Product() {
		
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
@Override
public String toString() {
	return "Product [prodCode=" + prodCode + ", prodName=" + prodName + ", price=" + price + "]";
}
@Override
public int hashCode() {
	System.out.println("hash code method executes...");
	return Objects.hash(price, prodCode, prodName);
}
@Override
public boolean equals(Object obj) {
	System.out.println("equal method executed...");
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && prodCode == other.prodCode
			&& prodName == other.prodName;
}
//@Override
//public int compareTo(Product args0) {//this method is from Comparable interface
//	System.out.println("In compareTo() method...");
//	if(this.prodCode > args0.prodCode ) {
//		return 1;
//	}
//	else if(this.prodCode < args0.prodCode) {
//		return -1;
//	}
//	return 0;
//}


//This is for comparing on the basis prodName(String) 
public int compareTo(Product args0) {//this method is from Comparable interface
	 System.out.println("In compareTo() method...");
	    if (this.prodName == null && args0.prodName == null) {
	        return 0;
	    } else if (this.prodName == null) {
	        return -1;
	    } else if (args0.prodName == null) {
	        return 1;
	    }

	    return this.prodName.compareTo(args0.prodName);
}
	

}
