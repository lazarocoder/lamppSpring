package com.blog.security;

import com.blog.dto.PostDto;
import com.blog.exception.PostNotFoundException;
import com.blog.model.Post;
import com.blog.repository.PostRepository;
import com.blog.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

// TODO: Auto-generated Javadoc
/**
 * The Class PostService.
 */
@Service
public class PostService {

    /** The auth service. */
    @Autowired
    private AuthService authService;
    
    /** The post repository. */
    @Autowired
    private PostRepository postRepository;

    /**
     * Show all posts.
     *
     * @return the list
     */
    @Transactional
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    /**
     * Creates the post.
     *
     * @param postDto the post dto
     */
    @Transactional
    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    /**
     * Read single post.
     *
     * @param id the id
     * @return the post dto
     */
    @Transactional
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    /**
     * Map from post to dto.
     *
     * @param post the post
     * @return the post dto
     */
    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUserName(post.getUserName());
        return postDto;
    }

    /**
     * Map from dto to post.
     *
     * @param postDto the post dto
     * @return the post
     */
    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        return post;
    }
}
