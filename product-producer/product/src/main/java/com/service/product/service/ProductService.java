package com.service.product.service;

import com.service.product.entity.Product;
import com.service.product.model.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(ProductDTO p);
    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();
    void deleteProductById(Long id);
    Product updateProduct(ProductDTO p);
}
