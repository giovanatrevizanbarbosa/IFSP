package controller;

import dto.ProductDto;
import model.entity.Product;
import model.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductController{
    private ProductService service;

    public ProductController(){
        service = new ProductService();
    }

    public boolean save(ProductDto productDto){
        var product = productDto.toModelDomain();
        return service.save(product);
    }

    public boolean updateById(int id, ProductDto updatedProduct){
        for(Product p : service.getAllProducts()){
            if (p.getId() == id){
                p.setName(updatedProduct.getName());
                p.setDescription(updatedProduct.getDescription());
                p.setPrice(updatedProduct.getPrice());
                p.setStock(updatedProduct.getStock());
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int id){
        return service.deleteById(id);
    }

    public List<ProductDto> getAllProducts(){
        List<ProductDto> list = new ArrayList<>();
        for(Product p : service.getAllProducts()) list.add(new ProductDto(p));
        return list;
    }

}
