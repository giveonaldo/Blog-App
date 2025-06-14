package com.abriadm.blog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abriadm.blog.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    
}
