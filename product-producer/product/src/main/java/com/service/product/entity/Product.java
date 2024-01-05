package com.service.product.entity;

import com.service.product.model.Attributes;
import com.service.product.model.Inventory;
import com.service.product.model.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    @Id
    private Long productId;
    private String name;
    private String brand;
    private String description;
    private ItemPrice price;
    private Inventory inventory;
    private List<Attributes> attributes;
}
