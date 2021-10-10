package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Post;

/**
 * The Interface PostRepository.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
