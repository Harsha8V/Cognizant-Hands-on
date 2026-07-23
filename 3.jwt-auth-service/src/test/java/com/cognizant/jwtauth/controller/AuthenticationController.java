package com.cognizant.jwtauth.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final String SECRET_KEY = "cognizant-secret-key-for-jwt-generation";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {

        String base64Credentials = authHeader.substring("Basic".length()).trim();

        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        String[] values = credentials.split(":", 2);
        String username = values[0];

        String token = generateJwt(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

    private String generateJwt(String username) {
        long expirationTimeInMillis = 1000 * 60 * 60; // 1 Hour

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}