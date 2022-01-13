package com.example.javaspringtutorial.repository.product;

import com.example.javaspringtutorial.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
