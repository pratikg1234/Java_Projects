package com.test.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJnitDemo {

	@AfterAll
	public static void cleanAll() {
		System.out.println("after all");
	}
	
	@BeforeAll
	public static void initAll() {
		System.out.println("before all");
	}
	@AfterEach
	public void clean() {
		System.out.println("after each method...");
	}
	@BeforeEach
	public void init() {
		System.out.println("before each method...");
	}
	@Test
	public void testArrayEquals() {
		int num1[]= {1,2,3,4};
		int num2[]= {1,2,3,4};
		assertArrayEquals(num1, num2);
	}
	
	@Test
	public void testFlag() {
		boolean x = true;
		assertTrue(x);
	}
	@Test
	public void testEquals() {
		String s1 ="Hello";
		String s2 = "Hello";
		assertEquals(s1, s2);
	}
}
