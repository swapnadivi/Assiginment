package com.service.product.controller;

import com.service.product.entity.Product;
import com.service.product.model.CartDetails;
import com.service.product.service.ProductService;
import com.service.product.service.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @PostMapping("/add-into-cart")
    public ResponseEntity<Boolean> checkProductAvailable(@RequestBody CartDetails cartDetails){
        Optional<Product> product = productService.findProductById(cartDetails.getProductId());
        if(product.isPresent()&&product.get().getInventory().getAvailable()>0){
            rabbitMqProducer.produceMessage(cartDetails);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }
}
