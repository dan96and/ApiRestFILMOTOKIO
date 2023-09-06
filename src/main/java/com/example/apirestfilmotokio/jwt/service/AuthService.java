package com.example.apirestfilmotokio.jwt.service;

import com.example.apirestfilmotokio.jwt.request.LoginRequest;
import com.example.apirestfilmotokio.jwt.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
}
