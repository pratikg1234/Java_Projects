package com.junit.login;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jnit.login.LoginService;

public class TestLogin {
	LoginService service;
	
	@BeforeEach
	public void init() {
		service=new LoginService();
	}
	
	@AfterEach
	public void cleanup() {
		service=null;
	}
	@Test
	public void testAuthenticateValidInput() {
		boolean res = service.authenticate("test", "test");
		assertTrue(res);
	}
	
	@Test
	public void testAuthenticateInvalidInput() {
		boolean res = service.authenticate("Test", "test");
		assertFalse(res);
	}
	
	//We can check for username & password seperately . There will be total 3 possibilities
	//username empty, password empty & both empty
	@Test
	public void testAuthenticateThrowIllegalUserPwdEmpty() {
		assertThrows(IllegalArgumentException.class,
					()->service.authenticate("", ""));
	}
	
	@Test
	public void testAuthenticateThrowIllegalUserPwdNull() {
		assertThrows(IllegalArgumentException.class,
					()->service.authenticate(null, null));
	}
	
	
}
