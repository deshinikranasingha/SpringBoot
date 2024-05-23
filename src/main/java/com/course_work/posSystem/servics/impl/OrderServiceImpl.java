package com.course_work.posSystem.servics.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_work.posSystem.entity.Order;
import com.course_work.posSystem.entity.Product;
import com.course_work.posSystem.repository.OrderRepository;
import com.course_work.posSystem.repository.ProductRepository;
import com.course_work.posSystem.servics.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addProductToOrder(Long orderId, Long productId, Integer quantity) {
        
        Order order = orderRepository.findById(orderId).orElse(null);

        if(order == null) {
            return null;
        }

        Product product = productRepository.findById(productId).orElse(null);
        
        if(product == null) {
            return null;
        }

        order.getOrderedProducts().add(product);
        order.setTotalPrice(order.getTotalPrice() + product.getPrice() * quantity);
        return orderRepository.save(order);
        
    }

    @Override
    public Order removeProductFromOrder(Long orderId, Long productId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        if(order == null) {
            return null;
        }

        Product product = productRepository.findById(productId).orElse(null);

        if(product == null) {
            return null;
        }

        order.getOrderedProducts().remove(product);
        order.setTotalPrice(order.getTotalPrice() - product.getPrice());
        return orderRepository.save(order);
    }
}