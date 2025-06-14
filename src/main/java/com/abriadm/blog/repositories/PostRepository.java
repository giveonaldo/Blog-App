package com.abriadm.blog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abriadm.blog.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID>{
    
}
