package com.example.demo.models;

import java.util.List;

import com.example.demo.DTO.OrderDTO;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    public OrderDTO getOrderById(Long orderId) {
        return orderService.getOrderById(orderId);
    }

    public OrderDTO addOrder(OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        return orderService.updateOrder(orderId, updatedOrderDTO);
    }

    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
