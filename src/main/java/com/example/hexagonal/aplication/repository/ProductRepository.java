package com.example.hexagonal.aplication.repository;

import com.example.hexagonal.domain.entity.Product;

public interface ProductRepository {
    Product createProduct(Product product);
}
