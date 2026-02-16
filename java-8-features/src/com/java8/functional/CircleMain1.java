package com.java8.functional;

public class CircleMain1{
	public static void main(String[] args) {
		Circle c = (r) -> System.out.println("Area: " + (3.14 * r * r));
		Circle c1 = (r1) -> System.out.println("Area: " + (3.14 * r1 * r1));
		
		
		c.area(100);
		c1.area(200);

	}
	
}
