package com.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

// TODO: Auto-generated Javadoc
/**
 * The Class Post.
 */
@Entity
@Table(name = "TB_COMMENT")
public class Comment {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The content. */
	@Lob
	@Column
	@NotEmpty
	private String content;

	/**
	 * The created on. data da criação
	 */
	@Column
	private LocalDateTime createdOn;

	/**
	 * The updated on. data da atualização
	 */
	@Column
	private LocalDateTime updatedOn;

	/** The user name. */
	@Column
	@NotBlank
	private String userName;

	@Column(name = "POST_ID", nullable = false)
	private Long postId;

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
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the updated on.
	 *
	 * @return the updated on
	 */
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * Sets the updated on.
	 *
	 * @param updatedOn the new updated on
	 */
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
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
	 * Sets the username.
	 *
	 * @param userName the new username
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
