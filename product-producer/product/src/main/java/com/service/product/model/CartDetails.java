package com.service.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {

    private Long productId;
    private int quantity;
    private Long userId;

    @Override
    public String toString() {
        return productId +
                "," + quantity+","+userId;
    }
}
