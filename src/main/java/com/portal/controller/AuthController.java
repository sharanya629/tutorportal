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
import com.portal.repository.UserRepository;
import com.portal.service.AuthenticationRequest;
import com.portal.service.AuthenticationResponse;
import com.portal.service.JwtUtil;
import com.portal.service.UserService;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    
    @GetMapping("/students/{id}")
    public User getUserDetails(@PathVariable int id) {
		User u = userRepository.findById(id);
		User usr = new User();
		usr.setId(u.getId());
		usr.setName(u.getName());
		usr.setMobile(u.getMobile());
		usr.setLocation(u.getLocation());
		usr.setEmail(u.getEmail());
    	return usr;
    	
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

       // return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt));
        String token= new AuthenticationResponse(jwt).toString();
        User usr1 = userRepository.findByEmail(authRequest.getEmail());
        String role = usr1.getRole();
        int id = usr1.getId();
        return ResponseEntity.ok().header("Authorization", "Bearer"+" "+jwt).header("role" + role).header("id" + id).body(jwt);
    }
}
