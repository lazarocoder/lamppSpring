package com.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Post.
 */
@Entity
@Table(name="TB_POST")
public class Post {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /** The title. */
    @NotBlank
    @Column
    private String title;
    
    /** The content. */
    @Lob
    @Column
    @NotEmpty
    private String content;
    
    /** The created on. 
     * data da criação*/
    @Column
    private LocalDateTime createdOn;
    
    /** The updated on. 
     * data da atualização*/
    @Column
    private LocalDateTime updatedOn;
    
    /** The user name. */
    @Column
    @NotBlank
    private String userName;

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
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
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
}
