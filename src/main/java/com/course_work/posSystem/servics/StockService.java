package com.course_work.posSystem.servics;

import java.util.List;

import com.course_work.posSystem.dto.StockDto;

public interface StockService {

    StockDto getStockById(Long id);
    List<StockDto> getAllStocks();
    void addProductsToStock(Long stockId, List<Long> productIds);
}
