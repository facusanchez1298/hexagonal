package com.example.hexagonal.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private final String id;
    private final Price price;
    private final String description;

    public boolean hasSellPrice() {
        return price != null && price.hasSellPrice();
    }

    public boolean hasBuyPrice() {
        return price != null && price.hasBuyPrice();
    }

    public String getBuyPrice() {
        return price.getBuyPrice();
    }

    public String getSellPrice() {
        return this.price.getSellPrice();
    }
}
