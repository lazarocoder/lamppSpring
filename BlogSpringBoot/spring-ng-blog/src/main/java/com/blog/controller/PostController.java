package com.blog.controller;

import com.blog.dto.PostDto;
import com.blog.security.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PostController.
 */
@RestController
@RequestMapping("/api/posts/")
public class PostController {

    /** The post service. */
    @Autowired
    private PostService postService;

    /**
     * Creates the post.
     *
     * @param postDto the post dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Show all posts.
     *
     * @return the response entity
     */
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    /**
     * Gets the single post.
     *
     * @param id the id
     * @return the single post
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }
}
