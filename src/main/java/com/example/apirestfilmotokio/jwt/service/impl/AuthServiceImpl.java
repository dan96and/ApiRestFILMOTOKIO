package com.example.apirestfilmotokio.jwt.service.impl;

import com.example.apirestfilmotokio.jwt.request.LoginRequest;
import com.example.apirestfilmotokio.jwt.response.AuthResponse;
import com.example.apirestfilmotokio.jwt.service.AuthService;
import com.example.apirestfilmotokio.jwt.service.JwtService;
import com.example.apirestfilmotokio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder().token(token).build();
    }
}
