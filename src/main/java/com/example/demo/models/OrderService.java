package com.example.demo.models;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.repositories.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId);
        return convertToDTO(order);
    }

    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        order = orderRepository.save(orderDTO);
        return convertToDTO(order);
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        OrderDTO existingOrder = getOrderById(orderId);

        existingOrder.setCustomerId(updatedOrderDTO.getCustomerId());
        existingOrder.setOrderDate(updatedOrderDTO.getOrderDate());
        existingOrder.setOrderStatus(updatedOrderDTO.getOrderStatus());

        orderRepository.save(existingOrder);
        return updatedOrderDTO;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    private Order convertToEntity(OrderDTO orderDTO) {
        return new Order(orderDTO.getOrderId(), orderDTO.getCustomerId(),
                orderDTO.getOrderDate(), orderDTO.getOrderStatus());
    }

    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(order.getOrderId(), order.getCustomerId(),
                order.getOrderDate(), order.getOrderStatus());
    }
}

