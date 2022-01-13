package com.example.javaspringtutorial.controller;

import com.example.javaspringtutorial.DTO.ProductDTO;
import com.example.javaspringtutorial.entity.Product;
import com.example.javaspringtutorial.response.ResponseApi;
import com.example.javaspringtutorial.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseApi> findAll(){
        List<Product> products = service.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();
        for (Product p: products) {
            dtoList.add(ProductDTO.productDTO(p));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseApi("success", 200, dtoList)
        );
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ProductDTO getById(@PathVariable int id){
        Product p = service.findById(id);
        ProductDTO productDTO = ProductDTO.productDTO(p);
        return productDTO;
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ProductDTO update(@PathVariable int id, @RequestBody Product product){
        Product p = service.update(id,product);
        ProductDTO productDTO = ProductDTO.productDTO(p);
        return productDTO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "{id}")
    public boolean delete(@PathVariable int id){
        return service.delete(id);
    }
}
