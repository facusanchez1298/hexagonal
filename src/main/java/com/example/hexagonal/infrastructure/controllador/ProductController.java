package com.example.hexagonal.infrastructure.controllador;

import com.example.hexagonal.infrastructure.adapter.ProductAdapter;
import com.example.hexagonal.infrastructure.controllador.request.ProductCreationRequest;
import com.example.hexagonal.infrastructure.controllador.response.ProductCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
