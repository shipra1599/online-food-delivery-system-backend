package com.delivery.order.entity;

	import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "order_items")
	public class OrderItem {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderItemId;

	    private Long itemId;

	    private Integer quantity;

	    @JsonBackReference
	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

	    public OrderItem() {}

	    public OrderItem(Long orderItemId, Long itemId, Integer quantity, Order order) {
	        this.orderItemId = orderItemId;
	        this.itemId = itemId;
	        this.quantity = quantity;
	        this.order = order;
	    }

	    public Long getOrderItemId() {
	        return orderItemId;
	    }

	    public void setOrderItemId(Long orderItemId) {
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

	    public Order getOrder() {
	        return order;
	    }

	    public void setOrder(Order order) {
	        this.order = order;
	    }
	}
