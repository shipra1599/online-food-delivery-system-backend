package com.delivery.order.dto;

public class OrderItemDTO {

    private Long itemId;
    private Integer quantity;

    public OrderItemDTO() {}

    public OrderItemDTO(Long itemId, Integer quantity) {
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
