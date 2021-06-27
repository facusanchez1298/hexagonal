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
        //todo search the chain setter method
        ProductDao productDao = new ProductDao();
        productDao.setDescription(product.getDescription());
        productDao.setBuyPrice(product.getBuyPrice());
        productDao.setSellPrice(product.getSellPrice());

        productDao = productRepositoryCrud.save(productDao);

        return Product.builder()
                .id(String.valueOf(productDao.getId()))
                .price(
                        Price.builder()
                                .sellPrice(productDao.getSellPrice())
                                .buyPrice(productDao.getBuyPrice())
                                .build()
                )
                .description(product.getDescription())
                .build();
    }
}
