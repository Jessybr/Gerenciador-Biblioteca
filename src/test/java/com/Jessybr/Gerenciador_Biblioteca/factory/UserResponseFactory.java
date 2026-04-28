package com.Jessybr.Gerenciador_Biblioteca.factory;

import java.time.LocalDate;

import com.Jessybr.Gerenciador_Biblioteca.dto.response.RegisterResponse;

public class UserResponseFactory {
    public static RegisterResponse createRegisterResponse() {
        RegisterResponse registerResponse = new RegisterResponse("novo_usuario", LocalDate.now(), LocalDate.now(), true);

        return registerResponse;
    }
}
