package main.exemplo_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/gitre/Downloads/teste.txt";
        List<Book> list;

        list = BookUtil.readBooks(path);

        for(Book b : list){
            System.out.println(b);
        }

        list.add(new Book(
                "Livro 1",
                "Giovana",
                "10",
                2024,
                100.00
        ));

        BookUtil.writeBooks(path, list);
    }
}
