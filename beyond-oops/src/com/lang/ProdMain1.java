package com.lang;

public class ProdMain1 {
	public static void main(String[] args) {
		Product p1 = new Product(100,"S25-Ultra");
		String s = p1.toString();
		System.out.println(s);
		
		Product p2 = new Product(100,"S25-Ultra");
		System.out.println(p1.equals(""));
		
		System.out.println(p1.compareTo(p2));
	}
}
