package com.examples.collections;

import java.util.Comparator;

public class ProductCodeComparator implements Comparator<Product>{

	public int compare(Product o1, Product o2) {
		return o1.getProdCode() - o2.getProdCode();
	}
}
