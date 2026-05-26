package com.delivery.payment.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.entity.Payment;
import com.delivery.payment.enums.PaymentMethod;
import com.delivery.payment.enums.PaymentStatus;
import com.delivery.payment.exception.PaymentNotFoundException;
import com.delivery.payment.kafka.OrderEvent;
import com.delivery.payment.mapper.PaymentMapper;
import com.delivery.payment.repository.PaymentRepository;
import com.delivery.payment.vo.PaymentVO;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;
    
    @Override
    public PaymentDTO createPayment(OrderEvent event) {

        Payment payment = new Payment();
        payment.setOrderId(event.getOrderId());
        payment.setAmount(event.getAmount());
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setPaymentMethod(PaymentMethod.COD);
        payment.setTransactionTime(LocalDateTime.now());
        Payment saved = paymentRepository.save(payment);

        return paymentMapper.toDTO(saved);
    }

    
    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));

        return paymentMapper.toDTO(payment);
    }
    
    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(payment->paymentMapper.toDTO(payment))
                .toList();
    }
}
                