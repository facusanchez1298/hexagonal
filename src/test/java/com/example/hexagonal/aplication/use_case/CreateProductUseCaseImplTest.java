package com.example.hexagonal.aplication.use_case;

import com.example.hexagonal.aplication.repository.ProductRepository;
import com.example.hexagonal.domain.entity.Product;
import com.example.hexagonal.domain.exception.ProductWithoutBuyPriceException;
import com.example.hexagonal.domain.exception.ProductWithoutSellPriceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseImplTest {

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Product product;

    @Mock
    private Product productReturned;

    @Test
    void shouldThrowAnProductWithoutSellPriceExceptionWhenTheProductHasNotSellPrice() {
        when(product.hasSellPrice()).thenReturn(false);

        Assertions.assertThatThrownBy(() -> createProductUseCase.execute(product))
                .isInstanceOf(ProductWithoutSellPriceException.class);
    }

    @Test
    void shouldThrowAnProductWithoutBuyPriceExceptionWhenTheProductHasNotBuyPrice() {
        when(product.hasSellPrice()).thenReturn(true);
        when(product.hasBuyPrice()).thenReturn(false);

        Assertions.assertThatThrownBy(() -> createProductUseCase.execute(product))
                .isInstanceOf(ProductWithoutBuyPriceException.class);
    }

    @Test
    void shouldReturnAProductWhenTheProductRepositoryReturned() {
        when(product.hasSellPrice()).thenReturn(true);
        when(product.hasBuyPrice()).thenReturn(true);
        when(productRepository.createProduct(product)).thenReturn(productReturned);

        Product result = createProductUseCase.execute(product);

        assertThat(result).isEqualTo(productReturned);
    }
}