package main.exemplo_4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Book book = new Book(
                "C Programming Absolute Beginner's Guide",
                "Greg Perry, Dean Miller",
                "3rd",
                2014,
                30.00);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("String: " + json);

        try{
            Book other = objectMapper.readValue(json, Book.class);
            System.out.println("to String:" + other);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}