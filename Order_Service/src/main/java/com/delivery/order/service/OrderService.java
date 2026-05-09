package com.delivery.order.service;

import java.util.List;

import com.delivery.order.dto.OrderDTO;
import com.delivery.order.entity.OrderItem;
import com.delivery.order.vo.OrderVO;

public interface OrderService {
	
	 OrderDTO createOrder(OrderVO vo);
	 List<Long> getAllOrderIds();
	 OrderDTO getOrderById(Long id);
	 OrderDTO updateOrderStatus(Long id, String status);
	 List<OrderItem> getOrderItems(Long id);
}
