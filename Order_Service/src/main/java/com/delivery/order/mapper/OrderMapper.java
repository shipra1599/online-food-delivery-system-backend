package com.delivery.order.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.delivery.order.dto.OrderDTO;
import com.delivery.order.dto.OrderItemDTO;
import com.delivery.order.entity.Order;
import com.delivery.order.entity.OrderItem;
import com.delivery.order.vo.OrderItemVO;
import com.delivery.order.vo.OrderVO;

@Component
public class OrderMapper {

    // VO → Entity
    public Order toEntity(OrderVO vo) {
        Order order = new Order();
        order.setRestaurantId(vo.getRestaurantId());
        order.setCustomerId(vo.getCustomerId());
        order.setTotalAmount(0.0); // initialized to avoid null

        List<OrderItem> items = vo.getItems().stream()
                .map(itemVO -> toEntity(itemVO, order))
                .collect(Collectors.toList());

        order.setItems(items);
        return order;
    }

    // VO → OrderItem Entity
    private OrderItem toEntity(OrderItemVO vo, Order order) {
        OrderItem item = new OrderItem();
        item.setItemId(vo.getItemId());
        item.setQuantity(vo.getQuantity());
        item.setOrder(order);
        return item;
    }

    // Entity → DTO
    public OrderDTO toDTO(Order order) {
        List<OrderItemDTO> itemDTOs = order.getItems().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

        return new OrderDTO(
                order.getOrderId(),
                order.getRestaurantId(),
                order.getCustomerId(),
                order.getTotalAmount(),
                order.getStatus(),
                itemDTOs
        );
    }

    // Entity → OrderItemDTO
    private OrderItemDTO toDTO(OrderItem item) {
        return new OrderItemDTO(
                item.getItemId(),
                item.getQuantity()
        );
    }
}
