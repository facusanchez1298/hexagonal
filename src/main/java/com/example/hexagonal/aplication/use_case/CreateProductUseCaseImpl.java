package com.example.hexagonal.aplication.use_case;

import com.example.hexagonal.aplication.repository.ProductRepository;
import com.example.hexagonal.domain.entity.Product;
import com.example.hexagonal.domain.exception.ProductWithoutBuyPriceException;
import com.example.hexagonal.domain.exception.ProductWithoutSellPriceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepository productRepository;

    @Override
    public Product execute(Product product) {
        if (!product.hasSellPrice()) {
            throw new ProductWithoutSellPriceException("The product has not sell price");
        }
        if (!product.hasBuyPrice()) {
            throw new ProductWithoutBuyPriceException("The product has not buy price");
        }
        return productRepository.createProduct(product);
    }
}
