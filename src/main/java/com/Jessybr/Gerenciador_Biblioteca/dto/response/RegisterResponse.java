package com.Jessybr.Gerenciador_Biblioteca.dto.response;

import java.time.LocalDate;

public record RegisterResponse(String username, LocalDate createdAt, LocalDate updatedAt, boolean accountNonExpired) {}
