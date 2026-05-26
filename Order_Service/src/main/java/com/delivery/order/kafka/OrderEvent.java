package com.delivery.order.kafka;

public class OrderEvent {
	
	 private Long orderId;
	 private Long customerId;
	 private Long restaurantId;
	 private Double amount;
	 private String status;
	
	 public OrderEvent() {

	}

	public OrderEvent(Long orderId, Long customerId, Long restaurantId, Double amount, String status) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.amount = amount;
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
