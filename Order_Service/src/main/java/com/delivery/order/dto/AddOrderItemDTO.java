package com.delivery.order.dto;

public class AddOrderItemDTO {
	
	private Long itemId;
	private Integer quantity;
	
	public AddOrderItemDTO() {
		super();
	}

	public AddOrderItemDTO(Long itemId, Integer quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	}
