package view;

import dao.UserDAOImpl;
import model.User;

public class Main {
    public static void main(String[] args) {
        //System.out.println("----------------- SISTEMA DE LOGIN -----------------");
        UserDAOImpl dao = UserDAOImpl.getInstance();

        User user1 = new User(1,"giovanatrevizan","gi.trevizan.barbosa@gmail.com","senha1234");

        User user2 = new User(2,"ednilsonrossi","ednilsonrossi@gmail.com",
         "senha4321");

        if(dao.insertUser(user1)){
            System.out.println("Usuário criado com sucesso.");
        }else{
            System.out.println("Erro ao criar usuário.");
        }

        if(dao.recoverPassword("giovanatrevizan"
                                ,"gi.trevizan.barbosa@gmail.com"
                                ,"gigi123")){
            System.out.println("Senha alterada com sucesso.");
        }else{
            System.out.println("Erro ao recuperar senha. Conta não encontrada");
        }

        if(dao.logIn("ednilsonrossi", "senha")){
            System.out.println("Login efetuado com sucesso.");
        }else{
            System.out.println("Erro ao efetuar o login.");
        }

    }
}