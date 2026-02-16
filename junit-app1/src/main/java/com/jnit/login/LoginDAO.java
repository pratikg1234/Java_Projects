package com.jnit.login;

public class LoginDAO {
	public boolean authenticate(String username, String password) {
		if(username == null || password == null) {
			throw new IllegalArgumentException("username or password cannot be null..");
		}
		if(username.length() == 0 || password.length() == 0) {
			throw new IllegalArgumentException("username and /or password is empty..");			
		}
		
		if(username.equals("test") && password.equals("test")) {
			return true;
		}
		return false;
	}
}
