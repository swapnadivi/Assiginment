package com.rabbitmq.productconsumer.service;

import com.rabbitmq.productconsumer.model.CartDetails;
import com.rabbitmq.productconsumer.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;
    @Override
    public List<CartDetails> findAllCartsByUserId(Long userId) {
        return cartRepository.findAllByUserId(userId);
    }
}
