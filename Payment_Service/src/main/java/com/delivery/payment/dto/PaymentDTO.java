package com.delivery.payment.dto;

import java.time.LocalDateTime;

import com.delivery.payment.enums.PaymentMethod;
import com.delivery.payment.enums.PaymentStatus;

public class PaymentDTO {

	private Long paymentId;
	private Long orderId;
	private Double amount;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	private LocalDateTime transactionTime;

	public PaymentDTO() {

	}

	public PaymentDTO(Long paymentId, Long orderId, Double amount, PaymentStatus paymentStatus,
			PaymentMethod paymentMethod, LocalDateTime transactionTime) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.transactionTime = transactionTime;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
}
