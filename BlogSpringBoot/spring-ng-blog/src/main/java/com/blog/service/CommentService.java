package com.blog.service;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dto.CommentDto;
import com.blog.exception.CommentNotFoundException;
import com.blog.model.Comment;
import com.blog.repository.CommentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentService.
 */
@Service
public class CommentService {

	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    /** The auth service. */
    @Autowired
    private AuthService authService;
    
    /** The comment repository. */
    @Autowired
    private CommentRepository commentRepository;

    /**
     * Show all comments.
     *
     * @return the list
     */
    @Transactional
    public List<CommentDto> showAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(this::mapFromCommentToDto).collect(toList());
    }
    
    @Transactional(readOnly = true)
    public List<CommentDto> findCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findCommentsByPostId(postId);
        return comments.stream().map(this::mapFromCommentToDto).collect(toList());
    }

    /**
     * Creates the comment.
     *
     * @param commentDto the comment dto
     */
    @Transactional
    public void createComment(CommentDto commentDto) {
        Comment comment = mapFromDtoToComment(commentDto);
        commentRepository.save(comment);
    }
    
    @Transactional
    public CommentDto updateComment(Long id, CommentDto commentDto) {
    	Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("For id " + id));
    	comment.setContent(commentDto.getContent());
    	comment.setUpdatedOn(LocalDateTime.now());
    	commentRepository.save(comment);
        return mapFromCommentToDto(comment);
    }

    /**
     * Read single comment.
     *
     * @param id the id
     * @return the comment dto
     */
    @Transactional
    public CommentDto readSingleComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("For id " + id));
        return mapFromCommentToDto(comment);
    }

    /**
     * Map from comment to dto.
     *
     * @param comment the comment
     * @return the comment dto
     */
    private CommentDto mapFromCommentToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setUserName(comment.getUserName());
        commentDto.setCreatedOn(dtf.format(comment.getCreatedOn()));
        if(comment.getUpdatedOn() != null) {
        	commentDto.setUpdatedOn(dtf.format(comment.getUpdatedOn()));
        }
        return commentDto;
    }

    /**
     * Map from dto to comment.
     *
     * @param commentDto the comment dto
     * @return the comment
     */
    private Comment mapFromDtoToComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        comment.setCreatedOn(LocalDateTime.now());
        comment.setUsername(loggedInUser.getUsername());
        comment.setPostId(commentDto.getPostId());
        return comment;
    }

    @Transactional
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}
}
