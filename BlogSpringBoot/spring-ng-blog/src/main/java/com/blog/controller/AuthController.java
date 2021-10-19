package com.blog.controller;

import com.blog.dto.LoginRequest;
import com.blog.dto.RegisterRequest;
import com.blog.service.AuthService;
import com.blog.service.AuthenticationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthController.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /** The auth service. */
    @Autowired
    private AuthService authService;

    /**
     * Signup.
     *
     * @param registerRequest the register request
     * @return the response entity
     */
    /*@GetMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }*/

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
    
    
    /**
     * Login.
     *
     * @param loginRequest the login request
     * @return the authentication response
     */
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
