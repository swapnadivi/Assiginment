package com.service.product.service;

import com.service.product.model.CartDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RMQProducerImpl implements RabbitMqProducer{
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RMQProducerImpl.class);

    private RabbitTemplate rabbitTemplate;

    public RMQProducerImpl(){

    }
    public RMQProducerImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Override
    public boolean produceMessage(CartDetails cartDetails) {
        rabbitTemplate.convertAndSend(exchange, routingKey, cartDetails.toString());
        return true;
    }
}
