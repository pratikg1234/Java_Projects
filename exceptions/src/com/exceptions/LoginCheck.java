package com.exceptions;

public class LoginCheck {
	public boolean authenticate(String username, String password) throws InvalidUserNameException {
		String dbUsername = "scott", dbPassword = "tiger";
		if(!username.equals(dbUsername) || !password.equals(dbPassword)) {
			throw new InvalidUserNameException(username);
		}
		System.out.println("Login Successful");
		return true;
	}
}
