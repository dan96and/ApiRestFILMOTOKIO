package com.example.apirestfilmotokio.jwt.service.impl;

import com.example.apirestfilmotokio.jwt.request.LoginRequest;
import com.example.apirestfilmotokio.jwt.response.AuthResponse;
import com.example.apirestfilmotokio.jwt.service.AuthService;
import com.example.apirestfilmotokio.jwt.service.JwtService;
import com.example.apirestfilmotokio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }
}
