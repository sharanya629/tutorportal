package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.portal.entity.User;
import com.portal.service.AuthenticationRequest;
import com.portal.service.AuthenticationResponse;
import com.portal.service.JwtUtil;
import com.portal.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    
    @GetMapping("/welcome") 
     public String welcomeUser() {
		return "Welcome to our application!";
    	
    }
    

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody AuthenticationRequest authRequest) throws Exception {
        try {
        	System.out.println("In signin method");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect email or password", e);
        }
        catch (Exception e) {
        	e.printStackTrace();
            throw new Exception("Other authentication exception occured", e);
            
        }
          

        final UserDetails userDetails = userService.loadUserByUsername(authRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt));
    }
}
