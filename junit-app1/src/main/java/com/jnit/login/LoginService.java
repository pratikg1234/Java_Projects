package com.jnit.login;

public class LoginService {
	private LoginDAO dao;
	public boolean authenticate(String username, String password) {
		dao = new LoginDAO();
		return dao.authenticate(username, password);
	}
}
