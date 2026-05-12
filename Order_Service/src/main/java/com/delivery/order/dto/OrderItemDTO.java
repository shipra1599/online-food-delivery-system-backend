package com.delivery.order.dto;

public class OrderItemDTO {

    private Long itemId;
    private Integer quantity;
    private Long orderItemId;

    public OrderItemDTO() {}

    public OrderItemDTO(Long itemId, Integer quantity, Long orderItemId) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderItemId = orderItemId;
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

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
    
}
