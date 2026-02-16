package com.java8.functional;

import java.util.Optional;

public class OptionalExample2 {
	public static void main(String[] args) {
//		opex1();
		prod();
	}
	public static void opex1() {
		Optional<Integer> op1 = Optional.empty();
		op1.ifPresentOrElse(
				(i) -> System.out.println("i = " + i),
				() -> System.out.println("Value is not present")
			);
	}
	
	public static void opex2() {
		Optional<String> op2 = Optional.ofNullable(null);
		op2.map((s)-> s.toLowerCase());
		op2.map((s)-> {return s.toLowerCase();});
		
	}
	
	public static void opex3() {
		    Optional<Customer> op3=Optional.of(new Customer(101, "Smith"));
			op3.ifPresent(c-> System.out.println(c.getCustId()+"--"+c.getCustName()));
		}
	
	public static void prod() {
		Optional<Product> op4=Optional.of(new Product(101, "galaxy",1000));
		op4.ifPresent(c-> System.out.println(c.getProdCode()+c.getProdName()+c.getPrice()));
		
		Optional<Product> emptyOptional = Optional.empty();
		 
        Product pr = new Product(19, "samsung", 450);
        Product finalProduct = emptyOptional.orElse(pr);
 
        System.out.println("Product Number: " + finalProduct.getProdCode());
        System.out.println("Product Name  : " + finalProduct.getProdName());
        System.out.println("Product Price : " + finalProduct.getPrice());
	}
	
	 
}
