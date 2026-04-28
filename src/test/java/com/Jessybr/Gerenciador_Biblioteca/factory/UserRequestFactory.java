package com.Jessybr.Gerenciador_Biblioteca.factory;

import com.Jessybr.Gerenciador_Biblioteca.dto.request.LoginRequest;
import com.Jessybr.Gerenciador_Biblioteca.dto.request.RegisterRequest;

public class UserRequestFactory {
    public static LoginRequest createLoginRequest() {
        LoginRequest loginRequest = new LoginRequest("jessica_admin", "senha123");

        return loginRequest;
    }

    public static RegisterRequest createRegisterRequest() {
        RegisterRequest registerRequest = new RegisterRequest("novo_usuario", "senha-123");

        return registerRequest;
    }

}
