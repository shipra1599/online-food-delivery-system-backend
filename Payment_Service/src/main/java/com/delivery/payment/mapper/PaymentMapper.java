package com.delivery.payment.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.entity.Payment;
import com.delivery.payment.enums.PaymentStatus;
import com.delivery.payment.vo.PaymentVO;

@Component
public class PaymentMapper {

    public PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPaymentId(payment.getPaymentId());
        dto.setOrderId(payment.getOrderId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setTransactionTime(payment.getTransactionTime());
        return dto;
    }

    public Payment toEntity(PaymentVO vo) {
        Payment payment = new Payment();
        payment.setOrderId(vo.getOrderId());
        payment.setAmount(vo.getAmount());
        payment.setPaymentMethod(vo.getPaymentMethod());
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setTransactionTime(LocalDateTime.now());
        return payment;
    }
}

