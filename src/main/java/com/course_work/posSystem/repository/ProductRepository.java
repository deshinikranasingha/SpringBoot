package com.course_work.posSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course_work.posSystem.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}