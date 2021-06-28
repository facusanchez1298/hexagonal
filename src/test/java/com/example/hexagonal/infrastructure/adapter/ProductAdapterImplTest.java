package com.example.hexagonal.infrastructure.adapter;

import com.example.hexagonal.aplication.use_case.CreateProductUseCase;
import com.example.hexagonal.domain.entity.Product;
import com.example.hexagonal.infrastructure.controllador.request.ProductCreationRequest;
import com.example.hexagonal.infrastructure.controllador.response.ProductCreationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.hexagonal.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductAdapterImplTest {

    @InjectMocks
    private ProductAdapterImpl productAdapter;

    @Captor
    private ArgumentCaptor<Product> productArgumentCaptor;

    @Mock
    private CreateProductUseCase createProductUseCase;

    @Mock
    private Product product;

    @Mock
    private ProductCreationRequest productRequest;


    @Test
    void shouldCallExecuteWithADescriptionEqualToProductCreationRequest() {
        when(productRequest.getDescription()).thenReturn(DESCRIPTION);
        when(createProductUseCase.execute(productArgumentCaptor.capture())).thenReturn(product);

        productAdapter.createProduct(productRequest);

        assertThat(productArgumentCaptor.getValue().getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    void shouldCallExecuteWithASellPriceEqualToProductCreationRequest() {
        when(productRequest.getSellPrice()).thenReturn(SELL_PRICE);
        when(createProductUseCase.execute(productArgumentCaptor.capture())).thenReturn(product);

        productAdapter.createProduct(productRequest);

        assertThat(productArgumentCaptor.getValue().getSellPrice()).isEqualTo(SELL_PRICE);
    }

    @Test
    void shouldCallExecuteWithABuyPriceEqualToProductCreationRequest() {
        when(productRequest.getBuyPrice()).thenReturn(BUY_PRICE);
        when(createProductUseCase.execute(productArgumentCaptor.capture())).thenReturn(product);

        productAdapter.createProduct(productRequest);

        assertThat(productArgumentCaptor.getValue().getBuyPrice()).isEqualTo(BUY_PRICE);
    }

    @Test
    void shouldReturnAProductWithTheSameIdReturnedForCreateProductUseCase() {
        when(createProductUseCase.execute(any(Product.class))).thenReturn(product);
        when(product.getId()).thenReturn(ID);

        ProductCreationResponse result =productAdapter.createProduct(productRequest);

        assertThat(result.getId()).isEqualTo(ID);
    }

    @Test
    void shouldReturnAProductWithTheSameSellPriceReturnedForCreateProductUseCase() {
        when(createProductUseCase.execute(any(Product.class))).thenReturn(product);
        when(product.getSellPrice()).thenReturn(SELL_PRICE);

        ProductCreationResponse result =productAdapter.createProduct(productRequest);

        assertThat(result.getSellPrice()).isEqualTo(SELL_PRICE);
    }

    @Test
    void shouldReturnAProductWithTheSameBuyPriceReturnedForCreateProductUseCase() {
        when(createProductUseCase.execute(any(Product.class))).thenReturn(product);
        when(product.getBuyPrice()).thenReturn(BUY_PRICE);

        ProductCreationResponse result =productAdapter.createProduct(productRequest);

        assertThat(result.getBuyPrice()).isEqualTo(BUY_PRICE);
    }

    @Test
    void shouldReturnAProductWithTheSameDescriptionReturnedForCreateProductUseCase() {
        when(createProductUseCase.execute(any(Product.class))).thenReturn(product);
        when(product.getDescription()).thenReturn(DESCRIPTION);

        ProductCreationResponse result =productAdapter.createProduct(productRequest);

        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
    }
}