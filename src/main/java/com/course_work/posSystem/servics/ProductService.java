package com.course_work.posSystem.servics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_work.posSystem.entity.Product;

@Service
public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
}