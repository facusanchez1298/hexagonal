package com.example.hexagonal.aplication.use_case;

import com.example.hexagonal.domain.entity.Product;

public interface CreateProductUseCase {
    Product execute(Product product);
}
