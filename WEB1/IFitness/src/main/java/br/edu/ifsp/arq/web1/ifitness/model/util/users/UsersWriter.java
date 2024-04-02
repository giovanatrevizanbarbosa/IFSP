package br.edu.ifsp.arq.web1.ifitness.model.util.users;

import br.edu.ifsp.arq.web1.ifitness.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersWriter {
    public static boolean write(User user){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        List<User> users = UsersReader.read();
        String path = "C:\\Users\\gitre\\IdeaProjects\\IFSP\\WEB1\\IFitness\\src\\main\\resources\\json\\users.json";

        if(users ==  null){
            // quando não tem nenhum objeto cadastrado
            users = new ArrayList<>();
            user.setId(1L);
        }else{
            // quando tem, verifica e-mail
            for(User u : users){
                if(u.getEmail().equals(user.getEmail())){
                    return false;
                }
            }
            // definir id do novo usuário
            User lastUser = users.get(users.size()-1);
            user.setId(lastUser.getId()+1);
        }
        // criptografar a senha
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        users.add(user);

        // converte para o formato JSON
        String json = gson.toJson(users);

        try{
            FileWriter writer = new FileWriter(path);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
