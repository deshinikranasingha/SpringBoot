package com.course_work.posSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course_work.posSystem.dto.ProductDto;
import com.course_work.posSystem.entity.Category;
import com.course_work.posSystem.entity.Product;
import com.course_work.posSystem.servics.CategoryService;
import com.course_work.posSystem.servics.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if(product != null) {
            return ResponseEntity.status(200).body(product);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        
        //find category using categoryId in the ProductDTO
        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);
        
        Product createdProduct = productService.createProduct(product);

        return ResponseEntity.status(201).body(createdProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        //find category using categoryId in the ProductDTO
        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);

        Product updatedProduct = productService.updateProduct(id, product);

        if(updatedProduct != null) {
            return ResponseEntity.status(200).body(updatedProduct);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}