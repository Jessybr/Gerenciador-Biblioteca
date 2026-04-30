package com.Jessybr.Gerenciador_Biblioteca.controlerTest;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.Jessybr.Gerenciador_Biblioteca.controller.UsuarioController;
import com.Jessybr.Gerenciador_Biblioteca.dto.request.RegisterRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.response.RegisterResponse;
import com.Jessybr.Gerenciador_Biblioteca.factory.UserRequestFactory;
import com.Jessybr.Gerenciador_Biblioteca.factory.UserResponseFactory;
import com.Jessybr.Gerenciador_Biblioteca.service.UsuarioService;

@WebMvcTest(UsuarioController.class)
public class UsuarioTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioService usuarioService;

    @Test
    void shouldCreateNewUser_AndReturnStatus200() {
        RegisterRequest request = UserRequestFactory.createRegisterRequest();
        RegisterResponse response = UserResponseFactory.createRegisterResponse();

        when(usuarioService.register(request)).thenReturn(response);

        mockMvc.perform(get("/user/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username").value("novo_usuario"))
            .andExpect(jsonPath("$.createAt").exists())
            .andExpect(jsonPath("$.updatedAt").exists())
            .andExpect(jsonPath("$.accountNonExpired").value(true));
    }

}
