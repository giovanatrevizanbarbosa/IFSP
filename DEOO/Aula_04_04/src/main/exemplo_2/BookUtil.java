package main.exemplo_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookUtil {
    public static List<Book> readBooks(String path) throws NoSuchElementException{
        List<Book> dataset = new ArrayList<>(10);

        File file = new File(path);
        try(var buffer = new BufferedReader(new FileReader(file))){
            String line = buffer.readLine();

            line = buffer.readLine();
            while(line != null && line.isEmpty()){
                String[] fields = line.split(";");
                String title = fields[0];
                String authors = fields[1];
                String edition = fields[2];
                int yearOfPublish = Integer.parseInt(fields[3]);
                double value = Double.parseDouble(fields[4]);

                dataset.add(new Book(title, authors, edition, yearOfPublish, value));

                line = buffer.readLine();
            }
        } catch (IOException e){
            System.err.println("Erro: " + e.getMessage());
        }

        return dataset;
    }

    public static void writeBooks(String path, List<Book> books){
        File file = new File(path);
        try(var buffer = new BufferedWriter((new FileWriter(file)))){
            buffer.write("Title;Author;Edition;YearOfPublish;Value");
            buffer.newLine();

            for(Book b : books){
                buffer.write(b.getTitle() + "; " +
                        b.getAuthors() + "; " +
                        b.getEdition() + "; " +
                        b.getYearOfPublish() + "; " +
                        b.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
