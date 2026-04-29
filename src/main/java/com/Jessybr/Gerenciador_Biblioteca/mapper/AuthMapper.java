package com.Jessybr.Gerenciador_Biblioteca.mapper;

import org.mapstruct.Mapper;

import com.Jessybr.Gerenciador_Biblioteca.domain.model.Usuario;
import com.Jessybr.Gerenciador_Biblioteca.dto.request.RegisterRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.RegisterResponse;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    Usuario toEntity(RegisterRequest request);

    RegisterResponse toResponse(Usuario usuario);
}
