package com.rabbitmq.productconsumer.controller;

import com.rabbitmq.productconsumer.model.CartDetails;
import com.rabbitmq.productconsumer.repository.CartRepository;
import com.rabbitmq.productconsumer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/consumer-carts")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/all-carts/{userId}")
    public ResponseEntity<CartDetails> fetchAllByUserId(Long userId){
        return new ResponseEntity(cartService.findAllCartsByUserId(userId), HttpStatus.OK);
    }
}
