package com.service.product.service;

import com.service.product.entity.Product;
import com.service.product.model.ProductDTO;
import org.springframework.beans.BeanUtils;

public class ProductUtils {


    public static ProductDTO entityToModel(Product p){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(p,productDTO);
        return productDTO;
    }

    public static Product modelToEntity(ProductDTO p){
        Product product = new Product();
        BeanUtils.copyProperties(p,product);
        return product;
    }
}
