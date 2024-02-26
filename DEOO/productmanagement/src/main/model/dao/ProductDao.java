package model.dao;

import model.entity.Product;

import java.util.List;

public interface ProductDao{
    List<Product> findAll();
    Product findById(int id);
    boolean insert(Product product);
    boolean updateById(int id, Product product);
    boolean deleteById(int id);
}
