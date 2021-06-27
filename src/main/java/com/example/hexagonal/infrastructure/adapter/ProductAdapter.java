package com.example.hexagonal.infrastructure.adapter;

import com.example.hexagonal.infrastructure.controllador.request.ProductCreationRequest;
import com.example.hexagonal.infrastructure.controllador.response.ProductCreationResponse;

public interface ProductAdapter {
    ProductCreationResponse createProduct(ProductCreationRequest productCreationRequest);
}
