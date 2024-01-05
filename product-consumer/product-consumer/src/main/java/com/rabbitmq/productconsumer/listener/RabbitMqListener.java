package com.rabbitmq.productconsumer.listener;

import com.rabbitmq.productconsumer.model.CartDetails;
import com.rabbitmq.productconsumer.repository.CartRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class RabbitMqListener {
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    CartRepository cartRepository;

    public RabbitMqListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        System.out.println("message recieved -" + message);
        String[] tokens = message != null ? message.split(",") : new String[1];
        if (tokens.length > 2) {
            CartDetails cartDetails = new CartDetails();
            cartDetails.setProductId(Long.valueOf(tokens[0]));
            cartDetails.setQuantity(Integer.valueOf(tokens[1]));
            cartDetails.setUserId(Long.valueOf(tokens[2]));
            cartRepository.save(cartDetails);
        }
    }
}
