package com.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCheckEven {
	
	@ParameterizedTest
	@ValueSource(ints = {2,4,6,8,10})
	public void testEven(int num) {
		assertTrue(CheckEven.even(num));
	}
}
