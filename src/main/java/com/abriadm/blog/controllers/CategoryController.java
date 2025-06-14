package com.abriadm.blog.controllers;

import com.abriadm.blog.domain.dtos.CategoryDto;
import com.abriadm.blog.entities.Category;
import com.abriadm.blog.mappers.CategoryMapper;
import com.abriadm.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<Category> categories = categoryService.listCategories();
        return ResponseEntity.ok(
            categories.stream()
                      .map(categoryMapper::toDto)
                      .toList()
        );
    }
}
