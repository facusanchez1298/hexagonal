package com.example.hexagonal.infrastructure.controllador;

import com.example.hexagonal.infrastructure.adapter.ProductAdapter;
import com.example.hexagonal.infrastructure.controllador.request.ProductCreationRequest;
import com.example.hexagonal.infrastructure.controllador.response.ProductCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductAdapter productAdapter;

    @PostMapping("/creation")
    public ResponseEntity<ProductCreationResponse> addProduct(
            @RequestBody ProductCreationRequest productCreationRequest
    ) {
        return ResponseEntity.ok(productAdapter.createProduct(productCreationRequest));
    }
}
