package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    boolean insertUser(User user);
    boolean deleteUser(int userId);
    boolean recoverPassword(String username, String email, String newPassword);
    boolean logIn(String username, String password);
    List<User> getUsers();
}