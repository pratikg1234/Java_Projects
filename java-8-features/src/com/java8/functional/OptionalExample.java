package com.java8.functional;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		Optional<String> o1 = Optional.of("Scott");
		System.out.println(o1.get());
		
		Optional<String> o2 = Optional.empty();
		o2.ifPresentOrElse((i)-> System.out.println(i), null);
		// System.out.println(o2.get());
		System.out.println();
		
		Optional<String> o3 = Optional.ofNullable(null);
		System.out.println(o3.get());
	}
}
