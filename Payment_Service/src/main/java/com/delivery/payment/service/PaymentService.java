package com.delivery.payment.service;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.vo.PaymentVO;

public interface PaymentService {
	
	 PaymentDTO createPayment(PaymentVO vo);
	 PaymentDTO getPaymentById(Long id);


}
