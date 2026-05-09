package com.delivery.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
