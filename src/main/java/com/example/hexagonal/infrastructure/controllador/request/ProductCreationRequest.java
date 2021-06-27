package com.example.hexagonal.infrastructure.controllador.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCreationRequest {
    private final String description;
    private final String sellPrice;
    private final String buyPrice;
}
