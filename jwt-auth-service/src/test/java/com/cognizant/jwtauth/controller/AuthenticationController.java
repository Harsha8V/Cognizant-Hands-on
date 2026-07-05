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

    // A secret key used to sign the JWT. In a real app, this should be in application.properties!
    private static final String SECRET_KEY = "cognizant-secret-key-for-jwt-generation";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {

        // 1. Read Authorization header and strip the "Basic " prefix
        String base64Credentials = authHeader.substring("Basic".length()).trim();

        // 2. Decode the base64 string
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        // The decoded string looks like "username:password". We split it to get the username.
        String[] values = credentials.split(":", 2);
        String username = values[0];

        // 3. Generate the token based on the retrieved username
        String token = generateJwt(username);

        // 4. Return the token in a JSON structure
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