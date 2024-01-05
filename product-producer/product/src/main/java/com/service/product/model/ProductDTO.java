package com.service.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String name;
    private String brand;
    private String description;
    private ItemPrice price;
    private Inventory inventory;
    private List<Attributes> attributes;



}
