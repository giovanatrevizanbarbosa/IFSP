package main.exemplo_3;

import java.io.*;

public class BookUtil {
    public static boolean writeBook(String path, Object object) throws IOException {
        File file = new File(path);

        if(!file.exists()){
            file.createNewFile();
        }

        var output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(object);
        output.flush();
        output.close();

        return true;
    }

    public static Object readBook(String path) throws IOException, ClassNotFoundException {
        File file = new File(path);
        var input = new ObjectInputStream(new FileInputStream(file));

        Object object = input.readObject();

        input.close();

        return object;
    }
}
