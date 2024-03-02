package model.service;

import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.entity.Product;

import java.util.List;

public class ProductService{
    private final ProductDao dao;
    public ProductService(){
        dao = ProductDaoImpl.getInstance();
    }

    public boolean save(Product product){
        if(product != null){
            return dao.insert(product);
        }
        return false;
    }

    public boolean deleteById(int id){
        return dao.deleteById(id);
    }

    public boolean updateById(int id, Product product){
        return dao.updateById(id, product);
    }

    public List<Product> getAllProducts(){
        return dao.findAll();
    }
}
