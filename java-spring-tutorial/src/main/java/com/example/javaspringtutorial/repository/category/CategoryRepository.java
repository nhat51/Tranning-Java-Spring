package com.example.javaspringtutorial.repository.category;

import com.example.javaspringtutorial.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
