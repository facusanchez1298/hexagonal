package com.example.hexagonal.infrastructure.controllador;

import com.example.hexagonal.infrastructure.adapter.ProductAdapter;
import com.example.hexagonal.infrastructure.controllador.request.ProductCreationRequest;
import com.example.hexagonal.infrastructure.controllador.response.ProductCreationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductAdapter productAdapter;

    @Mock
    private ProductCreationRequest productCreationRequest;

    @Mock
    private ProductCreationResponse productCreationResponse;

    @Test
    void shouldReturnAResponseEntityWithStatusOk() {
        when(productAdapter.createProduct(productCreationRequest))
                .thenReturn(productCreationResponse);

        ResponseEntity<ProductCreationResponse> result =
                productController.addProduct(productCreationRequest);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnAResponseEntityWithProductCreationResponseInTheBody() {
        when(productAdapter.createProduct(productCreationRequest))
                .thenReturn(productCreationResponse);

        ResponseEntity<ProductCreationResponse> result =
                productController.addProduct(productCreationRequest);

        assertThat(result.getBody()).isEqualTo(productCreationResponse);

    }
}