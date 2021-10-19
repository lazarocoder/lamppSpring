package com.blog.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The Class PostDto.
 */
public class CommentDto {
    
    /** The id. */
    private Long id;
    
    /** The content. */
    private String content;
    
    /** The user name. */
    private String userName;
    
    /** The created on. */
    private String createdOn;
    
    /** The post id. */
    private Long postId;
    
	/** The updated on. */
	private String updatedOn;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the updated on.
	 *
	 * @return the updated on
	 */
	public String getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * Sets the updated on.
	 *
	 * @param updatedOn the new updated on
	 */
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


}
