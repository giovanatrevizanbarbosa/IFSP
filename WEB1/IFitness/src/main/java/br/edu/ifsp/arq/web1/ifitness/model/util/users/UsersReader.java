package br.edu.ifsp.arq.web1.ifitness.model.util.users;

import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class UsersReader {
    public static List<User> read(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        List<User> users = null;
        String path = "/home/giovanatb/IdeaProjects/IFSP/WEB1/IFitness/src/main/resources/json/users.json";
        try{
            File file = new File(path);
            if(file.exists()){
                BufferedReader buffer = new BufferedReader(new FileReader(path));
                TypeToken<List<User>> type = new TypeToken<List<User>>() {};

                users = gson.fromJson(buffer, type);
                buffer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static User findUserByEmail(String email) {
        List<User> users = read();
        for (User user : users){
            if(user.getEmail().equals(email)) return user;
        }

        return null;
    }
}
