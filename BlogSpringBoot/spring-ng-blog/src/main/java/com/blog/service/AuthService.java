package com.blog.service;

import com.blog.dto.LoginRequest;
import com.blog.dto.RegisterRequest;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import com.blog.security.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthService.
 */
@Service
public class AuthService {

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;
    
    /** The password encoder. */
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /** The authentication manager. */
    @Autowired
    private AuthenticationManager authenticationManager;
    
    /** The jwt provider. */
    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Signup.
     *
     * @param registerRequest the register request
     */
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));

        userRepository.save(user);
    }

    /**
     * Encode password.
     *
     * @param password the password
     * @return the string
     */
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * Login.
     *
     * @param loginRequest the login request
     * @return the authentication response
     */
    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUserName());
    }

    /**
     * Gets the current user.
     *
     * @return the current user
     */
    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
