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

    public boolean delete(int id){
        return service.remove(id);
    }

    public List<ProductDto> getAllProducts(){
        List<ProductDto> list = new ArrayList<>();
        for(Product p : service.getAllProducts()) list.add(new ProductDto(p));
        return list;
    }

}
