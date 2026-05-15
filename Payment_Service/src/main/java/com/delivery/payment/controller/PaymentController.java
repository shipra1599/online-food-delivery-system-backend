package com.delivery.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.service.PaymentService;
import com.delivery.payment.vo.PaymentVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public PaymentDTO createPayment(@Valid @RequestBody PaymentVO vo) {
        return paymentService.createPayment(vo);
    }
    
    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(@PathVariable ("id") Long id) {
        return paymentService.getPaymentById(id);
    }

}
