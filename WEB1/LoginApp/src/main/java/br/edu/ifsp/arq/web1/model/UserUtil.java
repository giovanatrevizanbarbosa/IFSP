package br.edu.ifsp.arq.web1.model;

public class UserUtil {

	public User getUser(String email, String password) {
		return new User(email, password);
	}

}
