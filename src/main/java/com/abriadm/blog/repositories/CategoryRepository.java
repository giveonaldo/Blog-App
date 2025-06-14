package com.abriadm.blog.repositories;

import java.util.UUID;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{
    
}
