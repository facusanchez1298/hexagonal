package com.example.hexagonal.domain.exception;

public class ProductWithoutBuyPriceException extends RuntimeException {
    public ProductWithoutBuyPriceException(String message) {
        super(message);
    }
}
