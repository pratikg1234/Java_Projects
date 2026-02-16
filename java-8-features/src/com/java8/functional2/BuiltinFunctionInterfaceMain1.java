package com.java8.functional2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFunctionInterfaceMain1 {

	public static void main(String[] args) {
		m1((s)->s.toUpperCase());
		m2((i)-> i.endsWith("k"));
		m3((name)->System.out.println("Good Afternoon " + name));
		m4(()->"Supplier");
	}
	public static void m1(Function<String,String> f) {
		String x = f.apply("hello");
		System.out.println(x);
	}
	
	public static void m2(Predicate<String> p) {
		boolean result = p.test("pratik");
        System.out.println("Predicate output is: " + result);
	}
	
	public static void m3(Consumer<String> c) {
		c.accept("Pratik");
	}
	
	public static void m4(Supplier<String> s) {
		String res = s.get();
        System.out.println("Supplier output: " + res);
	}
	
}
