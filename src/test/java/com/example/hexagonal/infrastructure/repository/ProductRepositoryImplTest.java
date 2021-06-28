package com.example.hexagonal.infrastructure.repository;

import com.example.hexagonal.domain.entity.Product;
import com.example.hexagonal.infrastructure.dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.hexagonal.TestConstants.*;
import static com.example.hexagonal.TestConstants.BUY_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryImplTest {
    @InjectMocks
    private ProductRepositoryImpl productRepository;

    @Mock
    private ProductRepositoryCrud productRepositoryCrud;

    @Captor
    private ArgumentCaptor<ProductDao> productDaoArgumentCaptor;

    @Mock
    private ProductDao productDao;

    @Mock
    private Product product;

    @Test
    void shouldCallProductRepositoryCrudWithTheSameProductDaoDescriptionThatProduct() {
        when(productRepositoryCrud.save(productDaoArgumentCaptor.capture())).thenReturn(productDao);
        when(product.getDescription()).thenReturn(DESCRIPTION);

        productRepository.createProduct(product);

        assertThat(productDaoArgumentCaptor.getValue().getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    void shouldCallProductRepositoryCrudWithTheSameProductDaoSellPriceThatProduct() {
        when(productRepositoryCrud.save(productDaoArgumentCaptor.capture())).thenReturn(productDao);
        when(product.getSellPrice()).thenReturn(SELL_PRICE);

        productRepository.createProduct(product);

        assertThat(productDaoArgumentCaptor.getValue().getSellPrice()).isEqualTo(SELL_PRICE);
    }

    @Test
    void shouldCallProductRepositoryCrudWithTheSameProductDaoBuyPriceThatProduct() {
        when(productRepositoryCrud.save(productDaoArgumentCaptor.capture())).thenReturn(productDao);
        when(product.getBuyPrice()).thenReturn(BUY_PRICE);

        productRepository.createProduct(product);

        assertThat(productDaoArgumentCaptor.getValue().getBuyPrice()).isEqualTo(BUY_PRICE);
    }

    @Test
    void shouldReturnAProductWithTheSameIdThatTheProductDaoReturnedForTheRepository() {
        when(productRepositoryCrud.save(any())).thenReturn(productDao);
        when(productDao.getId()).thenReturn(PRODUCT_DAO_ID);

        Product result = productRepository.createProduct(product);
        assertThat(result.getId()).isEqualTo(String.valueOf(PRODUCT_DAO_ID));
    }
}