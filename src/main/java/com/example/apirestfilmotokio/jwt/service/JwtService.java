package com.example.apirestfilmotokio.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.HashMap;

public interface JwtService {

    String getToken(UserDetails user);
    String getUsernameFromToken(String token);
    Key getKey();
    boolean isTokenValid(String token, UserDetails userDetails);
}