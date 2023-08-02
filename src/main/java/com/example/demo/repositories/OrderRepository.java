package com.example.demo.repositories;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.models.Order;

public class OrderRepository{
    private final Map<Long, Order> ordersMap = new HashMap<>();

    public List<Order> findAll() {
        return null;
    }

    public Order findById(Long orderId) {
        return null;
    }

    public Order save(OrderDTO orderDTO) {
        return null;
    }

    public void deleteById(Long orderId) {
    }
}
