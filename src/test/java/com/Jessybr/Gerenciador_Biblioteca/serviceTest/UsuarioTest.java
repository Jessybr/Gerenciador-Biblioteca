package com.Jessybr.Gerenciador_Biblioteca.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Jessybr.Gerenciador_Biblioteca.domain.model.Usuario;
import com.Jessybr.Gerenciador_Biblioteca.dto.request.RegisterRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.RegisterResponse;
import com.Jessybr.Gerenciador_Biblioteca.factory.UserFactory;
import com.Jessybr.Gerenciador_Biblioteca.factory.UserRequestFactory;
import com.Jessybr.Gerenciador_Biblioteca.factory.UserResponseFactory;
import com.Jessybr.Gerenciador_Biblioteca.mapper.AuthMapper;
import com.Jessybr.Gerenciador_Biblioteca.repository.UserRepository;
import com.Jessybr.Gerenciador_Biblioteca.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthMapper mapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioService userService;

    @Test
    void shouldCreateNewUserWithCripytoPassword_AndReturnUser() {
        RegisterRequest requestUsuarioNovo = UserRequestFactory.createRegisterRequest();
        Usuario usuarioNovo = UserFactory.createUser();
        RegisterResponse responseUsuarioNovo = UserResponseFactory.createRegisterResponse();

        when(mapper.toEntity(any(RegisterRequest.class))).thenReturn(usuarioNovo);
        when(passwordEncoder.encode("senha-123")).thenReturn("senha-criptografada");
        when(userRepository.save(any(Usuario.class))).thenReturn(usuarioNovo);
        when(mapper.toResponse(any(Usuario.class))).thenReturn(responseUsuarioNovo);

        RegisterResponse result = userService.register(requestUsuarioNovo);

        assertNotEquals(requestUsuarioNovo.password(), usuarioNovo.getPassword());
        assertEquals(result.createdAt(), LocalDate.now());

        verify(passwordEncoder).encode(requestUsuarioNovo.password());
        verify(userRepository, times(1)).save(usuarioNovo);

    }
}
