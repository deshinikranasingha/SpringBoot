package com.course_work.posSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course_work.posSystem.dto.StockDto;
import com.course_work.posSystem.servics.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<StockDto> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/stocks")
    public StockDto getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping("/{stockId}/add_product")
    public void addProductsToStock(@PathVariable Long stockId, @RequestBody List<Long> productIds) {
        stockService.addProductsToStock(stockId, productIds);
    }
}
