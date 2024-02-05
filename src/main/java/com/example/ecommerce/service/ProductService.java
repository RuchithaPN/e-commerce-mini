package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Products;
import com.example.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Long productId, Products updatedProduct) {
        Optional<Products> existingProduct = productRepository.findById(productId);

        if (existingProduct.isPresent()) {
            Products product = existingProduct.get();
            product.setProductName(updatedProduct.getProductName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStockQuantity(updatedProduct.getStockQuantity());

            return productRepository.save(product);
        }

        return null; 
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

  
}
