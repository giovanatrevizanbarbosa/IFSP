package model.dao;

import model.entity.Product;

import java.util.List;
public class ProductDaoImpl implements ProductDao{
    private static ProductDaoImpl instance;
    private List<Product> products;

    public static ProductDaoImpl getInstance(){
        if(instance == null) instance = new ProductDaoImpl();
        return instance;
    }

    @Override
    public List<Product> findAll(){
        return products;
    }

    @Override
    public Product findById(int id){
        for(Product p : products) if(Product.getId() == id) return p;
        return null;
    }

    @Override
    public boolean insert(Product product){
        return products.add(product);
    }
    @Override
    public boolean updateById(int id, Product product){
        return products.set(id, product) != null;
    }
    @Override
    public boolean deleteById(int id){
        for(Product p : products) {
            if(Product.getId() == id) return products.remove(p);
        }
        return false;
    }
}
