package com.example.hexagonal.infrastructure.controllador.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCreationResponse {
    private final String description;
    private final String sellPrice;
    private final String buyPrice;
    private final String id;
}
