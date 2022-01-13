package com.example.javaspringtutorial.service.category;

import com.example.javaspringtutorial.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    Category update(int id, Category category);
    boolean delete(int id);
}
