package dto;

import model.entity.Product;

public class ProductDto{
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public ProductDto(String name, String description, double price, int stock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public Product toModelDomain(){
        return new Product(getName()
                ,getDescription()
                ,getPrice()
                ,getStock());
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
