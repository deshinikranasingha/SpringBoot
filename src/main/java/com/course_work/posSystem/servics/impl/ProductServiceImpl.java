package com.course_work.posSystem.servics.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_work.posSystem.entity.Product;
import com.course_work.posSystem.repository.ProductRepository;
import com.course_work.posSystem.servics.ProductService;

    @Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existProduct = productRepository.findById(id).orElse(null);

        if(existProduct == null) {
            return null;
        }

        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        existProduct.setCategory(product.getCategory());

        return productRepository.save(existProduct);

    }
}