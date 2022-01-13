package com.example.javaspringtutorial.service.category;


import com.example.javaspringtutorial.entity.Category;
import com.example.javaspringtutorial.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImp implements CategoryService {

    @Autowired
    CategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category findById(int id) {
        Optional<Category> category = repo.findById(id);
        if (!category.isPresent()){
            return null;
        }
        return  category.get();
    }

    @Override
    public Category save(Category category) {
        return repo.save(category);
    }

    @Override
    public Category update(int id, Category category) {
        Category exist = repo.getById(id);
        if (exist != null){
            exist.setName(category.getName());
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Optional<Category> category = repo.findById(id);
        if (!category.isPresent()){
            return false;
        }else {
            repo.delete(category.get());
            return true;
        }
    }
}
