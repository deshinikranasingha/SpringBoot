package com.course_work.posSystem.servics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_work.posSystem.entity.Category;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
}