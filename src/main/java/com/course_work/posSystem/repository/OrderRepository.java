package com.course_work.posSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course_work.posSystem.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}