package com.demo.coverage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestCalculator {
	private Calculator c1 = new Calculator();
	
	@Test
	public void testAdd() {
		assertEquals(10, c1.add(4, 6));
	}
	
	@Test
	public void testSubtractGreater() {
		assertEquals(1, c1.subtract(4, 3));
	}
	
	@Test
	public void testSubtractLesser() {
		assertEquals(1, c1.subtract(3, 4));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(12, c1.multiply(3, 4));
	}
	
	@Test
	public void testDivide() {
		assertEquals(3, c1.divide(12, 4));
	}
	
	@Test
	//for handling divide by zero exception (e.g. 10/0)
	public void testDivideThrows() {
		assertThrows(ArithmeticException.class, ()->c1.divide(10, 0));
	}
}
