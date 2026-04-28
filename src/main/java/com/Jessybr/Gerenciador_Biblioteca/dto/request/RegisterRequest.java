package com.Jessybr.Gerenciador_Biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
    @NotBlank
    String username, 
    
    @NotBlank
    String password) {}
