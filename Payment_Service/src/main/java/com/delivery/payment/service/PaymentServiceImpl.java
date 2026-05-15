package com.delivery.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.entity.Payment;
import com.delivery.payment.exception.PaymentNotFoundException;
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
    public PaymentDTO createPayment(PaymentVO vo) {
        Payment payment = paymentMapper.toEntity(vo);
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
                