package com.rabbitmq.productconsumer.repository;

import com.rabbitmq.productconsumer.model.CartDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<CartDetails,Long> {
    List<CartDetails> findAllByUserId(Long userId);
}
