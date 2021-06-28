package com.example.hexagonal.infrastructure.repository;

import com.example.hexagonal.aplication.repository.ProductRepository;
import com.example.hexagonal.domain.entity.Price;
import com.example.hexagonal.domain.entity.Product;
import com.example.hexagonal.infrastructure.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductRepositoryCrud productRepositoryCrud;

    @Override
    public Product createProduct(Product product) {
        ProductDao productDao = getProductDao(product);
        ProductDao productDaoResponse = productRepositoryCrud.save(productDao);
        return getProduct(product, productDaoResponse);
    }

    private Product getProduct(Product product, ProductDao productDaoResponse) {
        return Product.builder()
                .id(String.valueOf(productDaoResponse.getId()))
                .price(
                        Price.builder()
                                .sellPrice(productDaoResponse.getSellPrice())
                                .buyPrice(productDaoResponse.getBuyPrice())
                                .build()
                )
                .description(product.getDescription())
                .build();
    }

    private ProductDao getProductDao(Product product) {
        return new ProductDao()
                .setDescription(product.getDescription())
                .setBuyPrice(product.getBuyPrice())
                .setSellPrice(product.getSellPrice());
    }
}
