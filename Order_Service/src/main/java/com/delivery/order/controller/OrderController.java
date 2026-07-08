package com.delivery.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(
    name = "Order API",
    description = "Endpoints for creating and managing customer orders"
)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(
        summary = "Create a new order",description = "Creates a new order"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Order created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid order request")
    })
    @PostMapping("/add")
    public OrderDTO createOrder(@Valid @RequestBody OrderVO vo) {
        return orderService.createOrder(vo);
    }

    @Operation(
        summary = "Get all order IDs",description = "Returns a list of all order IDs in the system."
    )
    @ApiResponse(responseCode = "200", description = "Order IDs retrieved successfully")
    @GetMapping("/showAllId")
    public List<Long> getAllOrderIds() {
        return orderService.getAllOrderIds();
    }

    @Operation(
        summary = "Get order by ID",description = "Fetches order details using the order ID."
    )
    @ApiResponse(responseCode = "200", description = "Order retrieved successfully")
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @Operation(
        summary = "Update order status",description = "Updates the status of an existing order"
    )
    @ApiResponse(responseCode = "200", description = "Order status updated successfully")
    @PutMapping("/{id}/status")
    public OrderDTO updateOrderStatus(@PathVariable("id") Long id, @RequestBody String status) {
        return orderService.updateOrderStatus(id, status);
    }

    @Operation(
        summary = "Get items list",description = "Returns all items associated with a specific order."
    )
    @ApiResponse(responseCode = "200", description = "Order items retrieved successfully")
    @GetMapping("/{id}/items")
    public List<OrderItem> getOrderItems(@PathVariable("id") Long id) {
        return orderService.getOrderItems(id);
    }

    @Operation(
        summary = "Add an item to an order",description = "Adds a new item to an existing order."
    )
    @ApiResponse(responseCode = "200", description = "Item added to order successfully")
    @PostMapping("/{orderId}/items")
    public String addItemToOrder(@PathVariable("orderId") Long orderId, @RequestBody AddOrderItemDTO dto) {
        return orderService.addItemToOrder(orderId, dto);
    }

    @Operation(
        summary = "Remove an item from an order",description = "Deletes a specific item from an order."
    )
    @ApiResponse(responseCode = "200", description = "Item removed from order successfully")
    @DeleteMapping("/{orderId}/items/{orderItemId}")
    public String removeItemFromOrder(@PathVariable("orderId") Long orderId, @PathVariable("orderItemId") Long orderItemId) {
        return orderService.removeItemFromOrder(orderId, orderItemId);
    }
}
