package com.Jessybr.Gerenciador_Biblioteca.service;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Jessybr.Gerenciador_Biblioteca.domain.enums.RoleType;
import com.Jessybr.Gerenciador_Biblioteca.domain.model.Usuario;
import com.Jessybr.Gerenciador_Biblioteca.dto.request.RegisterRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.RegisterResponse;
import com.Jessybr.Gerenciador_Biblioteca.exception.EmailAlreadyExistsException;
import com.Jessybr.Gerenciador_Biblioteca.mapper.AuthMapper;
import com.Jessybr.Gerenciador_Biblioteca.repository.UserRepository;

@Service
public class UsuarioService {
    private final UserRepository userRepository;
    private final AuthMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UserRepository userRepository, AuthMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request) {
        if(!userRepository.findByUsername(request.username()).isEmpty()) {
            throw new EmailAlreadyExistsException("Esse e-mail já está em uso.");
        }

        Usuario usuario = mapper.toEntity(request);
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setRole(RoleType.ROLE_OPERADOR);
        usuario.setCreatedAt(LocalDate.now());
        usuario.setUpdatedAt(LocalDate.now());
        userRepository.save(usuario);

        return mapper.toResponse(usuario);
    }
}