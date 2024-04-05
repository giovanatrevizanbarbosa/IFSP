package main.exemplo_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String path = "/Users/gitre/Downloads/teste.txt";
        File file = new File(path);
        String line;

        try(var bufferedReader = new BufferedReader(new FileReader(file))) {
            line = bufferedReader.readLine();

            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Erro: "+ e.getMessage());
        }
    }
}
