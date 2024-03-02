package model.dataset;

import model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDataset{
    private static ProductDataset instance = null;
    private List<Product> dataset;

    private ProductDataset(){
        dataset = new ArrayList<>();
    }

    public static ProductDataset getInstance(){
       if(instance == null) instance = new ProductDataset();
       return instance;
    }

    public boolean insertProduct(Product product){
        return this.dataset.add(product);
    }

    public boolean deleteProduct(Product product){
        return this.dataset.remove(product);
    }

    public Product getProduct(int id){
        for(Product p : dataset) if(p.getId() == id) return p;
        return null;
    }
}
