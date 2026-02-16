package com.exceptions;

public class InvalidUserNameException extends Exception{
	String username;
	public InvalidUserNameException() {
		
	}
	public InvalidUserNameException(String username) {
		this.username=username;
	}
	@Override
	public String toString() {
		return "InvalidUserNameException [username=" + username + "]";
	}
}
