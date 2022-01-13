package com.example.javaspringtutorial.service.product;

import com.example.javaspringtutorial.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    Product update(int id, Product product);
    boolean delete(int id);
}
