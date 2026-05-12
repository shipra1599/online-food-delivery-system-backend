package com.delivery.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.order.dto.AddOrderItemDTO;
import com.delivery.order.dto.OrderDTO;
import com.delivery.order.entity.OrderItem;
import com.delivery.order.service.OrderService;
import com.delivery.order.vo.OrderVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public OrderDTO createOrder(@Valid @RequestBody OrderVO vo) {
        return orderService.createOrder(vo);
    }
    
    @GetMapping("/showAllId")
    public List<Long> getAllOrderIds() {
        return orderService.getAllOrderIds();
    }
    
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
    
    @PutMapping("/{id}/status")
    public OrderDTO updateOrderStatus(@PathVariable ("id") Long id, @RequestBody String status) {
        return orderService.updateOrderStatus(id, status);
    }
    
    @GetMapping("/{id}/items")
    public List<OrderItem> getOrderItems(@PathVariable("id") Long id) {
        return orderService.getOrderItems(id);
    }
    
    @PostMapping("/{orderId}/items")
    public String addItemToOrder(@PathVariable("orderId") Long orderId,@RequestBody AddOrderItemDTO dto) {
        return orderService.addItemToOrder(orderId, dto);
    }

    @DeleteMapping("/{orderId}/items/{orderItemId}")
    public String removeItemFromOrder(@PathVariable ("orderId") Long orderId,@PathVariable ("orderItemId") Long orderItemId) {
        return orderService.removeItemFromOrder(orderId, orderItemId);
    }

}