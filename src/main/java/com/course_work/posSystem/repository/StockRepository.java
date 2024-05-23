package com.course_work.posSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_work.posSystem.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
