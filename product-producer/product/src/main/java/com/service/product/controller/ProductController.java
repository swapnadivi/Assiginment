package com.service.product.controller;

import com.service.product.entity.Product;
import com.service.product.model.CartDetails;
import com.service.product.model.ProductDTO;
import com.service.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity createProd(@RequestBody ProductDTO p){
        return ResponseEntity.ok(productService.saveProduct(p));
    }

    @GetMapping("/productId/{productId}")
    public ResponseEntity<Product> findById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.findProductById(productId).get());
    }



    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO p){
        return ResponseEntity.ok(productService.updateProduct(p));
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
}



