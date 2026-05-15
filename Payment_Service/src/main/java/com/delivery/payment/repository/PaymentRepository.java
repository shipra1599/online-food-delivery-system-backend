package com.delivery.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> { 

}
