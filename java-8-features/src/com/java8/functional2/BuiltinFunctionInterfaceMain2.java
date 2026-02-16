package com.java8.functional2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFunctionInterfaceMain2 {
	public static void main(String[] args) {
		productFunction(prod -> prod.getPrice());
		productPredicate((p)->p.getPrice()>2000);
		productSupplier(() -> new Product(101, "iPhone", 999.99));
		productConsumer((con)->System.out.println(con.getProdCode()+" "+ con.getPrice()+500 +" "+ con.getProdName().toUpperCase()));
	}
	
	public static void productFunction(Function<Product,Double> p) {
		Product p1=new Product(101,"samsung",10000);
//		p1.setPrice(9000);
		double priceResult=p.apply(p1);
		System.out.println("Price is: " + priceResult);
	}
	public static void productPredicate(Predicate<Product> p) {
		Product p1 = new Product();
		p1.setPrice(10000);
		boolean result=p.test(p1);
		System.out.println("Prdicate Customer result is: "+result);
	}
	
	public static void productConsumer(Consumer<Product> p) {
		Product pr =new Product(102,"redmi",20000);
		p.accept(pr);
	}
	
	public static void productSupplier(Supplier<Product> p) {
		Product pr =p.get();
		System.out.println("New Supplier Object is: "+pr);
	}
	
}
