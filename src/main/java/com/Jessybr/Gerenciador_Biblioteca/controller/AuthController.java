package com.Jessybr.Gerenciador_Biblioteca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jessybr.Gerenciador_Biblioteca.dto.request.LoginRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.AuthResponse;
import com.Jessybr.Gerenciador_Biblioteca.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @Operation(summary = "Autentica usuário e retorna token")
    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@RequestBody LoginRequest request) {
        AuthResponse token = authService.login(request);

        return ResponseEntity.ok(token);
    }
    
}
