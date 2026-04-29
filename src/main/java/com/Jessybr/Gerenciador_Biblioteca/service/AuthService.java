package com.Jessybr.Gerenciador_Biblioteca.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Jessybr.Gerenciador_Biblioteca.dto.request.LoginRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.AuthResponse;
import com.Jessybr.Gerenciador_Biblioteca.security.JwtService;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    } 

    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        UserDetails user = (UserDetails) authentication.getPrincipal();

        AuthResponse response = new AuthResponse(jwtService.gerarToken(user));

        return response;
    }
}
