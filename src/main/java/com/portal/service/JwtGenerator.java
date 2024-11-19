package com.portal.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtGenerator {
    public static void main(String[] args) {
        // Replace with your secret key
        String secretKey = "your-very-secure-secret-key";

        // Create the algorithm for signing the token
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        // Set the payload data
        String token = JWT.create()
                .withIssuer("auth0")
               // .withClaim("userId", 1)
                .withClaim("username", "postgres")
               // .withClaim("role", "Tutor")
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // Token expires in 1 hour
                .sign(algorithm);

        System.out.println("Generated JWT: " + token);
    }
}
