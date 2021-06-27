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
        Product product = Product.builder()
                .price(
                        Price.builder()
                                .buyPrice(
                                        productCreationRequest.getBuyPrice()
                                )
                                .sellPrice(
                                        productCreationRequest.getSellPrice()
                                )
                                .build()
                )
                .description(
                        productCreationRequest.getDescription()
                )
                .build();

        product = createProductUseCase.execute(product);

        return ProductCreationResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .buyPrice(product.getBuyPrice())
                .sellPrice(product.getSellPrice())
                .build();
    }
}
