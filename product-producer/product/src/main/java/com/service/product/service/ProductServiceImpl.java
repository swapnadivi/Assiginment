package com.service.product.service;

import com.service.product.ProductRepository;
import com.service.product.entity.Product;
import com.service.product.model.ProductDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDTO p) {
        Product product = ProductUtils.modelToEntity(p);
        Long id = RandomGenerator.getDefault().nextLong();
        product.setProductId(id);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
            productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(ProductDTO p) {
        if(!productRepository.existsById(p.getProductId())){
            throw new RuntimeException("Product Not found");
        }
        Product product = ProductUtils.modelToEntity(p);
        return productRepository.save(product);
    }
}
