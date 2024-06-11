package br.edu.ifsp.arq.web1.ifitness.model.util.activity;

import br.edu.ifsp.arq.web1.ifitness.model.Activity;
import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesReader {
    public static List<Activity> read(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        List<Activity> activities = null;
        try{
            File file = new File("/home/giovanatb/IdeaProjects/IFSP/WEB1/IFitness/src/main/resources/json/activities.json");
            if(file.exists()){
                BufferedReader buffer = new BufferedReader(new FileReader("/home/giovanatb/IdeaProjects/IFSP/WEB1/IFitness/src/main/resources/json/activities.json"));

                TypeToken<List<Activity>> type = new TypeToken<List<Activity>>() {};
                activities = gson.fromJson(buffer, type);
                buffer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return activities;
    }

    public static List<Activity> readByUser(User user){
        List<Activity> activities = read();
        List<Activity> userActivities = new ArrayList<>();

        if (activities != null) {
            for(Activity a : activities){
                if(a.getUser().getId().equals(user.getId())){
                    userActivities.add(a);
                }
            }
            return userActivities;
        }
        return null;
    }

    public static Activity findById(Long id) {
        List<Activity> activities = read();

        for(Activity a : activities){
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }

    public static List<Activity> getActivityByFilter(ActivitiesFilter filter){
        List<Activity> activities = readByUser(filter.getUser());

        if(filter.getType() != null) {
            activities = activities.stream()
                    .filter(a -> a.getType() == filter.getType()).toList();
        }
        if(filter.getInitialDate() != null){
            activities = activities.stream()
                    .filter(a -> a.getDate().isAfter(filter.getInitialDate())).toList();
        }
        if(filter.getFinalDate() != null){
            activities = activities.stream()
                    .filter(a -> a.getDate().isBefore(filter.getFinalDate())).toList();
        }

        return activities;
    }
}
