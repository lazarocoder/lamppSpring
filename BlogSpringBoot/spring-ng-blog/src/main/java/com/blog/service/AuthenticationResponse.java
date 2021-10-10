package com.blog.service;

import lombok.AllArgsConstructor;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new authentication response.
 *
 * @param authenticationToken the authentication token
 * @param username the username
 */
@AllArgsConstructor
public class AuthenticationResponse {
    
    /** The authentication token. */
    private String authenticationToken;
    
    /** The username. */
    private String username;
}
