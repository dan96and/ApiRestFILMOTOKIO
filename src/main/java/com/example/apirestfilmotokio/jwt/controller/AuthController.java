package com.example.apirestfilmotokio.jwt.controller;

import com.example.apirestfilmotokio.jwt.request.LoginRequest;
import com.example.apirestfilmotokio.jwt.response.AuthResponse;
import com.example.apirestfilmotokio.jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}