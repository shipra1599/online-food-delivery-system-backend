package com.delivery.payment.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.delivery.payment.service.PaymentService;

@Component
public class OrderConsumer {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topics = "order_created", groupId = "payment-group")
    public void consume(OrderEvent event) {
        paymentService.createPayment(event);
    }
}