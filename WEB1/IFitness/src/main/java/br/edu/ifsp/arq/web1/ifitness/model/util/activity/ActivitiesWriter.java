package br.edu.ifsp.arq.web1.ifitness.model.util.activity;

import br.edu.ifsp.arq.web1.ifitness.model.Activity;
import br.edu.ifsp.arq.web1.ifitness.model.util.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesWriter {
    public static boolean write(Activity activity) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        List<Activity> activities = ActivitiesReader.read();
        String path = "C:/Users/gitre/IdeaProjects/IFSP/WEB1/IFitness/src/main/resources/json/activities.json";

        if (activities == null) {
            // quando não tem nenhum objeto cadastrado
            activities = new ArrayList<>();
            activity.setId(1L);
        } else {
            Activity lastActivity = activities.get(activities.size() - 1);
            activity.setId(lastActivity.getId() + 1);
        }
        activities.add(activity);

        // converte para o formato JSON
        String json = gson.toJson(activities);

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static boolean update(Activity activity) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        List<Activity> activities = ActivitiesReader.read();
        String path = "C:/Users/gitre/IdeaProjects/IFSP/WEB1/IFitness/src/main/resources/json/activities.json";

        int index = 0;
        for (Activity a : activities) {
            if (a.getId().equals(activity.getId())) {
                activities.set(index, activity);
            }
            index++;
        }

        // converte para o formato JSON
        String json = gson.toJson(activities);

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static boolean delete(Activity activity){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        List<Activity> activities = ActivitiesReader.read();
        String path = "C:/Users/gitre/IdeaProjects/IFSP/WEB1/IFitness/src/main/resources/json/activities.json";

        activities.remove(activity);

        // converte para o formato JSON
        String json = gson.toJson(activities);

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}