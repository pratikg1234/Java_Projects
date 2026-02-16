package com.main;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class TestAll {
	@Test
    public void testMultipleExample() {
        assertAll(
        		()->assertEquals(10, 5+5),
        		()->assertNull(null),
        		()->assertFalse(false));
    }
}
