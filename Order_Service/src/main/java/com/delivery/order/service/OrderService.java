package com.delivery.order.service;

import com.delivery.order.dto.OrderDTO;
import com.delivery.order.vo.OrderVO;

public interface OrderService {
	
	 OrderDTO createOrder(OrderVO vo);

}
