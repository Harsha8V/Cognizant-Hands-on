package com.cognizant.jwtauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for REST APIs
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll() // Allow everyone to access the auth endpoint
                .anyRequest().authenticated(); // Secure all other endpoints

        return http.build();
    }
}