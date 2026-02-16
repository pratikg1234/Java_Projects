package com.examples.collections;
 
import java.util.Comparator;
 
public class ProdNameComparator implements Comparator<Product> {
 
	@Override
	public int compare(Product o1, Product o2) {
		System.out.println("Inside prodname comparator in compare method");
		return o1.getProdName().compareTo(o2.getProdName());
	}
	
}