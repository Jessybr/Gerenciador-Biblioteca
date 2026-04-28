package com.Jessybr.Gerenciador_Biblioteca.mapper;

import com.Jessybr.Gerenciador_Biblioteca.domain.model.Usuario;
import com.Jessybr.Gerenciador_Biblioteca.dto.request.RegisterRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.RegisterResponse;

public class AuthMapper {
    public Usuario toEntity(RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.username());
        usuario.setPassword(request.password());

        return usuario;
    }

    public RegisterResponse toResponse(Usuario usuario) {
        RegisterResponse response = new RegisterResponse(usuario.getUsername(), usuario.getCreatedAt(), usuario.getUpdatedAt(), usuario.isAccountNonExpired());
        return response;
    }
}
