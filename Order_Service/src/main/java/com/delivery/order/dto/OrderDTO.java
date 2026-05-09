package com.delivery.order.dto;

import java.util.List;

import com.delivery.order.enums.OrderStatus;

public class OrderDTO {

    private Long orderId;
    private Long restaurantId;
    private Long customerId;
    private Double totalAmount;
    private OrderStatus status;
    private List<OrderItemDTO> items;

    public OrderDTO() {}

    public OrderDTO(Long orderId, Long restaurantId, Long customerId, Double totalAmount,
                    OrderStatus status, List<OrderItemDTO> items) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
