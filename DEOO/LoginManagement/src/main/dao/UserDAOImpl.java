package dao;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAOImpl implements UserDAO {
    private List<User> users;
    private static UserDAOImpl instance;

    private UserDAOImpl(){
        users = new ArrayList<User>();
    }

    public static UserDAOImpl getInstance() {
        if(instance == null){
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public boolean insertUser(User user){
        if(validateInsertUser(user)){
            return users.add(user);
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        User user = findUserById(userId);
        if(user != null){
            return users.remove(user);
        }
        return false;
    }

    @Override
    public boolean logIn(String username, String password) {
        User user = findUserByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public boolean recoverPassword(String username, String email, String newPassword) {
        User user = findUserByUsername(username);
        if(user != null && user.getEmail().equals(email)){
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    public boolean validateInsertUser(User user){
        if(user.getUsername() != null && user.getEmail() != null && user.getPassword() != null){
            if(findUserByUsername(user.getUsername()) == null  && findUserByEmail(user.getEmail()) == null){
                return true;
            }
        }
        return false;
    }

    public User findUserByUsername(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public User findUserByEmail(String email){
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User findUserById(int id){
        for(User user : users){
            if(user.getUserId() == id){
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

//    @Override
//    public String toString(){
//        return "Usuários cadastrados: "
//                + ;
//    }
}
