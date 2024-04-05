package main.exemplo_2;

public class Book {
    private String title;
    private String authors;
    private String edition;
    private int yearOfPublish;
    private double value;

    public Book(String title, String authors, String edition, int yearOfPublish, double value) {
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

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", edition='" + edition + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", value=" + value +
                '}';
    }


}

