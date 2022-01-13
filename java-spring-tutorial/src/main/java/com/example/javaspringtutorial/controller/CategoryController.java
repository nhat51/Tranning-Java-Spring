package com.example.javaspringtutorial.controller;


import com.example.javaspringtutorial.entity.Category;
import com.example.javaspringtutorial.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> finAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category save(@RequestBody Category category){
        return service.save(category);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Category findById(@PathVariable int id){
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean delete(@PathVariable int id){
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Category update(@RequestBody Category category,@PathVariable int id){
        return service.update(id,category);
    }

}
