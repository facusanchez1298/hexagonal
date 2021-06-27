package com.example.hexagonal.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Price {
    private final String sellPrice;
    private final String buyPrice;

    public boolean hasSellPrice() {
        return sellPrice != null && !sellPrice.equals("");
    }

    public boolean hasBuyPrice() {
        return buyPrice != null && !buyPrice.equals("");
    }
}
