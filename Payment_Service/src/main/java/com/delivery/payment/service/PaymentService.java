package com.delivery.payment.service;

import java.util.List;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.kafka.OrderEvent;
import com.delivery.payment.vo.PaymentVO;

public interface PaymentService {
	
	 PaymentDTO createPayment(OrderEvent event);
	 PaymentDTO getPaymentById(Long id);
	 List<PaymentDTO> getAllPayments();



}
