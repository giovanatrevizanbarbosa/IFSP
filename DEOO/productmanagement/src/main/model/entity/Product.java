package model.entity;

public class Product{
    private static int productSequence = 0;
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product(String name, String description, double price, int stock){
        this.id = nextVal();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    private static int nextVal(){
        return ++productSequence;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}
