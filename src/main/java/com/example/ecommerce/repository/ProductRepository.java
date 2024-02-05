package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
}

