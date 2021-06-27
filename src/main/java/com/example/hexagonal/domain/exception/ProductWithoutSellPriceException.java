package com.example.hexagonal.domain.exception;

public class ProductWithoutSellPriceException extends RuntimeException {
    public ProductWithoutSellPriceException(String message) {
        super(message);
    }
}
