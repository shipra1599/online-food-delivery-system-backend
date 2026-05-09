package com.delivery.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.order.dto.OrderDTO;
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

}