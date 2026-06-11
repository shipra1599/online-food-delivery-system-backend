package com.delivery.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.order.dto.AddOrderItemDTO;
import com.delivery.order.dto.MenuDTO;
import com.delivery.order.dto.OrderDTO;
import com.delivery.order.entity.Order;
import com.delivery.order.entity.OrderItem;
import com.delivery.order.enums.OrderStatus;
import com.delivery.order.exception.InvalidOrderStatusException;
import com.delivery.order.exception.MenuItemNotFoundException;
import com.delivery.order.exception.MenuServiceUnavailableException;
import com.delivery.order.exception.OrderItemNotFoundException;
import com.delivery.order.exception.OrderNotFoundException;
import com.delivery.order.feign.menuclient.MenuClient;
import com.delivery.order.kafka.OrderEvent;
import com.delivery.order.kafka.OrderProducer;
import com.delivery.order.mapper.OrderMapper;
import com.delivery.order.repository.OrderRepository;
import com.delivery.order.vo.OrderVO;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private MenuClient menuClient;
    
    @Autowired
    private OrderProducer orderProducer;

    @Override
    @CircuitBreaker(name = "menuService", fallbackMethod = "menuFallback")
    public OrderDTO createOrder(OrderVO vo) {

        // Convert VO → Entity
        Order order = mapper.toEntity(vo);

        // Validate each item using Feign and calculate total
        double total = calculateTotalUsingFeign(order.getItems());
        order.setTotalAmount(total);

        // Default status
        order.setStatus(OrderStatus.CREATED);
        // Save order
        Order savedOrder = orderRepository.save(order); 
        OrderEvent event = new OrderEvent(
                savedOrder.getOrderId(),
                savedOrder.getCustomerId(),
                savedOrder.getRestaurantId(),
                savedOrder.getTotalAmount(),
                "CREATED"
        );

        orderProducer.sendOrderEvent(event);
        // Convert Entity → DTO
        return mapper.toDTO(savedOrder);
    }

    // Price calculation using Feign
    private double calculateTotalUsingFeign(List<OrderItem> items) {

        return items.stream()
                .mapToDouble(item -> {

                    MenuDTO menu;

                    try {
                        menu = menuClient.getMenuById(item.getItemId());
                    } catch (FeignException.NotFound e) {
                        throw new MenuItemNotFoundException(
                                "Menu item not found with id: " + item.getItemId()
                        );
                    }

                    return menu.getPrice() * item.getQuantity();
                })
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

    @Override
    public String removeItemFromOrder(Long orderId, Long orderItemId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        OrderItem itemToRemove = order.getItems().stream()
                .filter(i -> i.getOrderItemId().equals(orderItemId))
                .findFirst()
                .orElseThrow(() -> new OrderItemNotFoundException("Order item not found"));

        order.getItems().remove(itemToRemove);

        orderRepository.save(order);

        return "Item removed successfully";
    }
    
   // Adding fallback methods 
    
    public OrderDTO menuFallback(OrderVO vo, Throwable ex) {

        // If it's a business exception, rethrow it
        if (ex instanceof MenuItemNotFoundException) {
            throw (RuntimeException) ex;
        }

        // Otherwise, Menu Service not available
        throw new MenuServiceUnavailableException(
            "Menu Service is unavailable. Please try again later."
        );
    }
}
