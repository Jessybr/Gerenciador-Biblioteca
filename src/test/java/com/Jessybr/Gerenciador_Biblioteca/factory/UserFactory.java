package com.Jessybr.Gerenciador_Biblioteca.factory;

import java.time.LocalDate;

import com.Jessybr.Gerenciador_Biblioteca.domain.enums.RoleType;
import com.Jessybr.Gerenciador_Biblioteca.domain.model.Usuario;

public class UserFactory {
    public static Usuario createUser() {
        Usuario usuario = new Usuario(1L, "Jessica", "senha-criptografada", RoleType.ROLE_ADMIN, LocalDate.now(), LocalDate.now(), true);

        return usuario;
    }
}
