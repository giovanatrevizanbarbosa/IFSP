package main.exemplo_3;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String authors;
    private String edition;
    private int yearOfPublish;
    private Double value;

    public Book(String title, String authors, String edition, int yearOfPublish, Double value) {
        this.title = title;
        this.authors = authors;
        this.edition = edition;
        this.yearOfPublish = yearOfPublish;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getEdition() {
        return edition;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", edition='" + edition + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", value=" + value +
                '}';
    }
}