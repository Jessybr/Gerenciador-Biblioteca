package com.Jessybr.Gerenciador_Biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jessybr.Gerenciador_Biblioteca.domain.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username); 
}
