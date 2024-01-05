package com.rabbitmq.productconsumer.service;

import com.rabbitmq.productconsumer.model.CartDetails;

import java.util.List;

public interface CartService {
    List<CartDetails> findAllCartsByUserId(Long userId);
}
