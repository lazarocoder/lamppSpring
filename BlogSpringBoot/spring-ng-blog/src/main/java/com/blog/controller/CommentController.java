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
import com.blog.service.CommentService;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentController.
 */
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    /** The comment service. */
    @Autowired
    private CommentService commentService;

    /**
     * Creates the comment.
     *
     * @param commentDto the comment dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    /**
     * Update comment.
     *
     * @param id the id
     * @param commentDto the comment dto
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
    	commentDto = commentService.updateComment(id, commentDto);
        return ResponseEntity.ok(commentDto);
    }
    
    /**
     * Delete comment.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id) {
    	commentService.deleteComment(id);
    }

    /**
     * Show all comments.
     *
     * @return the response entity
     */
    @GetMapping("/all")
    public ResponseEntity<List<CommentDto>> showAllComments() {
        return new ResponseEntity<>(commentService.showAllComments(), HttpStatus.OK);
    }

    /**
     * Gets the single comment.
     *
     * @param id the id
     * @return the single comment
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getSingleComment(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(commentService.readSingleComment(id), HttpStatus.OK);
    }
}
