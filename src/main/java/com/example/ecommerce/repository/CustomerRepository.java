package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}

