package main.exemplo_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static main.exemplo_3.BookUtil.readBook;
import static main.exemplo_3.BookUtil.writeBook;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/gitre/Downloads/livros.bin";

        Book book = new Book(
                "Livro 1",
                "Giovana",
                "10",
                2024,
                100.00
        );

        try{
            writeBook(path, book);
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try{
           book = (Book) readBook(path);
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(book);

        List<Book> bookList = new ArrayList<>();
        path = "/Users/gitre/Downloads/dataset.bin";
            try{
            BookUtil.writeBook(path, bookList);
        }catch (IOException e){
            System.err.println("Erro: " + e.getMessage());
        }

        List<Book> readList = null;
            try {
            readList = (List<Book>) BookUtil.readBook(path);
        }catch (Exception e){
            System.err.println("Erro: " + e.getMessage());
        }
            System.out.println("--- RECUPERADOS ---");
            for(Book l : readList){
            System.out.println(l);
        }
    }

}
