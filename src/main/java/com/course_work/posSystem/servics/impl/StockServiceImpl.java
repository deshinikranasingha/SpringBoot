package com.course_work.posSystem.servics.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_work.posSystem.dto.StockDto;
import com.course_work.posSystem.entity.Product;
import com.course_work.posSystem.entity.Stock;
import com.course_work.posSystem.repository.ProductRepository;
import com.course_work.posSystem.repository.StockRepository;
import com.course_work.posSystem.servics.StockService;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public StockDto getStockById(Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        return convertToDto(stock);
    }

    @Override
    public List<StockDto> getAllStocks() {
        return stockRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void addProductsToStock(Long stockId, List<Long> productIds) {
        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new RuntimeException("Stock not found"));
        List<Product> products = productRepository.findAllById(productIds);
        stock.getProducts().addAll(products);
        stockRepository.save(stock);
    }

    private StockDto convertToDto(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setProductIds(stock.getProductIds());
        return stockDto;
    }
}
