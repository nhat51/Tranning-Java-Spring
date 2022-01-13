package com.example.javaspringtutorial.service.product;

import com.example.javaspringtutorial.entity.Product;
import com.example.javaspringtutorial.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImp implements ProductService{
    @Autowired
    ProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = repository.findById(id);
        if (!product.isPresent()){
            return null;
        }
        return  product.get();
    }

    @Override
    public Product save(Product product) {

        return repository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        Product exist = repository.getById(id);
        if (exist != null){
            exist.setName(product.getName());
            exist.setPrice(product.getPrice());
            exist.setThumbnail(product.getThumbnail());
            exist.setCategoryId(product.getCategoryId());
            return repository.save(exist);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Optional<Product> product = repository.findById(id);
        if (!product.isPresent()){
            return false;
        }else {
            repository.delete(product.get());
            return true;
        }
    }
}
