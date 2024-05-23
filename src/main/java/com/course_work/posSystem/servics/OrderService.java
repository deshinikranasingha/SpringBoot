package com.course_work.posSystem.servics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_work.posSystem.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order addProductToOrder(Long orderId, Long productId, Integer quantity);
    Order removeProductFromOrder(Long orderId, Long productId);
}