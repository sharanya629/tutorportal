package com.portal.service;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public JwtUtil jwtUtil() {
//        return new JwtUtil();
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.portal.entity.User;

@Configuration
public class AppConfig {

    @Bean
    public User user() {
        return new User();
    }
}