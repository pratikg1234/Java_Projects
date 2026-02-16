package com.java8.functional2;

public class Example1 {
	public static void main(String[] args) {
		m1(r->Math.PI*r*r);
	}
	public static void m1(Circle c) {
		double a = c.area(3.2);
		System.out.println("Area= "+a);
	}
}
