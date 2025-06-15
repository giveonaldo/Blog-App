package com.abriadm.blog.services;

import java.util.List;
import java.util.UUID;

import com.abriadm.blog.entities.Category;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
}
