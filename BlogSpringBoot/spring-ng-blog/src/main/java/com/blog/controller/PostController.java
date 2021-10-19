package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CommentDto;
import com.blog.dto.PostDto;
import com.blog.security.PostService;
import com.blog.service.CommentService;

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
    
    /** The comment service. */
    @Autowired
    private CommentService commentService;

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
     * Update post.
     *
     * @param id the id
     * @param postDto the post dto
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
    	postDto = postService.updatePost(id, postDto);
        return ResponseEntity.ok(postDto);
    }
    
    /**
     * Delete post.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
    	postService.deletePost(id);
    }

    /**
     * Show all posts.
     *
     * @return the response entity
     */
    @GetMapping("public/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }
    
    /**
     * Buscar comments.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentDto>> buscarComments(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.findCommentsByPostId(id));
    }
    
    /**
     * Buscar comments.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("{id}/public/comments")
    public ResponseEntity<List<CommentDto>> buscarPublicComments(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.findCommentsByPostId(id));
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
    
    /**
     * Gets the single post.
     *
     * @param id the id
     * @return the single post
     */
    @GetMapping("/public/get/{id}")
    public ResponseEntity<PostDto> getPublicSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }
}
