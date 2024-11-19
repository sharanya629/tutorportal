//package com.portal.service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//import javax.crypto.SecretKey;
//
//public class JwtVerifier {
//
//    private static final SecretKey key = JwtUtil.key; // Use the same key from JwtUtil
//
//    public Claims verifyToken(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(key) // Use the same key for parsing
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}
