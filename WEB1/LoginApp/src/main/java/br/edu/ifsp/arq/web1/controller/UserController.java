package br.edu.ifsp.arq.web1.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.web1.model.User;

public class UserController {
	private static UserController instance;
	private List<User> users;
	
	private UserController() {
        users = new ArrayList<>();

        users.add(new User("gi.trevizan.barbosa@gmail.com", "12345"));
        users.add(new User("fernandovieira@gmail.com", "54321"));
    }
	
	public static synchronized UserController getInstance(){
		if(instance == null) return new UserController();
		return instance;
	}
	
	public boolean authtenticateUser(User user) {
		for(User u : users) {
			if(user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())) return true;			
		}
		return false;
	}
}