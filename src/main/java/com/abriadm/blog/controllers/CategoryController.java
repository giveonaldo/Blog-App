package com.abriadm.blog.controllers;

import com.abriadm.blog.domain.dtos.CategoryDto;
import com.abriadm.blog.domain.dtos.CreateCategoryRequest;
import com.abriadm.blog.entities.Category;
import com.abriadm.blog.mappers.CategoryMapper;
import com.abriadm.blog.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
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
        List<CategoryDto> categories = categoryService.listCategories()
            .stream().map(category -> categoryMapper.toDto(category))
            .toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
        @Valid @RequestBody CreateCategoryRequest createCategoryRequest
    ) 
    {
        Category categoryToCreate = categoryMapper.toEntity(createCategoryRequest);
        Category saveCategory = categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(
            categoryMapper.toDto(saveCategory), 
            HttpStatus.CREATED
        );
    }
}
