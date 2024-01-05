package com.service.product.service;

import com.service.product.model.CartDetails;

public interface RabbitMqProducer {
    boolean produceMessage(CartDetails cartDetails);
}
