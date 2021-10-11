package com.blog.model;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name="TB_USER")
public class User {
    
    /** The id. 
     * Geração de tabela automática ao iniciar a aplicação
     * @GeneratedValue(strategy = GenerationType.AUTO*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /** The user name. */
    @Column
    private String userName;
    
    /** The password. */
    @Column
    private String password;
    
    /** The email. */
    @Column
    private String email;

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
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
