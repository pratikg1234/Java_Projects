package com.exceptions;

public class ExceptionExample1 {
	public static void main(String[] args) {
		throwDemo();
//		divideZero();
//		nullExpDemo();
//		arrayIndex();
//		System.out.println("This line is after exception...");
	}
	
	public static void throwDemo() {
		throw new NullPointerException("I am thown purposefully");
	}
	public static void arrayIndex() {
		try {
			int num[] = { 1, 2, 3 };
			System.out.println(num[5]);
		} catch (NullPointerException e) {
			System.out.println("Exception caught..."+e);
			e.printStackTrace();
		}
		finally {
			System.out.println("This is in finally block...");
		}
		System.out.println("This is out of finally block, this will not be executed..");
	}
	public static void nullExpDemo() {
		try {
			String s1 = null;
			int len = s1.length();
		}
		catch (NullPointerException e) {
			System.out.println("Nullpointer exception caught here..."+e.getMessage());
		}
		
	}
	public static void divideZero() {
		try {
			System.out.println("Hello World..");
			int a =10/0;
			System.out.println("good morning");
		}
		catch(ArithmeticException e) {
			System.out.println("Exception caught here.. "+e.getMessage());
		}
		System.out.println("JVM continues from here...");
		
	}
}
