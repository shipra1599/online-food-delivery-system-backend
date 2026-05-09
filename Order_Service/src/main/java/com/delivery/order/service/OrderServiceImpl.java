package com.delivery.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.order.dto.AddOrderItemDTO;
import com.delivery.order.dto.OrderDTO;
import com.delivery.order.entity.Order;
import com.delivery.order.entity.OrderItem;
import com.delivery.order.enums.OrderStatus;
import com.delivery.order.exception.InvalidOrderStatusException;
import com.delivery.order.exception.OrderNotFoundException;
import com.delivery.order.mapper.OrderMapper;
import com.delivery.order.repository.OrderRepository;
import com.delivery.order.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public OrderDTO createOrder(OrderVO vo) {

        // Convert VO → Entity
        Order order = mapper.toEntity(vo);

        // Calculate total amount ,later will be done by Feign call)
        double total = calculateTotal(order.getItems());
        order.setTotalAmount(total);

        // Default status
        order.setStatus(OrderStatus.CREATED);

        // Save order
        Order savedOrder = orderRepository.save(order);

        // Convert Entity → DTO
        return mapper.toDTO(savedOrder);
    }

    private double calculateTotal(List<OrderItem> items) {
                return items.stream()
                .mapToDouble(i -> i.getQuantity() * 100.0) // temporary price, will be replaced by Feign call to Menu Service
                .sum();
    }
    
    @Override
    public List<Long> getAllOrderIds() {
        return orderRepository.findAll()
                .stream()
                .map(order -> order.getOrderId())
                .toList();
    }
    
    @Override
    public OrderDTO getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        return mapper.toDTO(order);
    }

    
    @Override
    public OrderDTO updateOrderStatus(Long id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        // Convert string → enum
        OrderStatus newStatus;
        try {
            newStatus = OrderStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new InvalidOrderStatusException("Invalid status: " + status);
        }
        order.setStatus(newStatus);
        Order updated = orderRepository.save(order);
        return mapper.toDTO(updated);
    }
    
    @Override
    public List<OrderItem> getOrderItems(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        return order.getItems();
    }
    
    @Override
    public String addItemToOrder(Long orderId, AddOrderItemDTO dto) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        OrderItem item = new OrderItem();
        item.setItemId(dto.getItemId());
        item.setQuantity(dto.getQuantity());
        item.setOrder(order);

        order.getItems().add(item);

        orderRepository.save(order);

        return "Item added successfully";
    }

}
