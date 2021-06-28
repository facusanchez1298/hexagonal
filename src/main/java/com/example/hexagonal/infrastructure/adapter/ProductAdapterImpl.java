package com.example.hexagonal.infrastructure.adapter;

import com.example.hexagonal.aplication.use_case.CreateProductUseCase;
import com.example.hexagonal.domain.entity.Price;
import com.example.hexagonal.domain.entity.Product;
import com.example.hexagonal.infrastructure.controllador.request.ProductCreationRequest;
import com.example.hexagonal.infrastructure.controllador.response.ProductCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductAdapterImpl implements ProductAdapter {
    private final CreateProductUseCase createProductUseCase;

    @Override
    public ProductCreationResponse createProduct(ProductCreationRequest productCreationRequest) {
        Product product = getProduct(productCreationRequest);

        Product productResponse = createProductUseCase.execute(product);

        return ProductCreationResponse.builder()
                .id(productResponse.getId())
                .description(productResponse.getDescription())
                .buyPrice(productResponse.getBuyPrice())
                .sellPrice(productResponse.getSellPrice())
                .build();
    }

    private Product getProduct(ProductCreationRequest productCreationRequest) {
        return Product.builder()
                .price(
                        Price.builder()
                                .buyPrice(productCreationRequest.getBuyPrice())
                                .sellPrice(productCreationRequest.getSellPrice())
                                .build()
                )
                .description(productCreationRequest.getDescription())
                .build();
    }
}
