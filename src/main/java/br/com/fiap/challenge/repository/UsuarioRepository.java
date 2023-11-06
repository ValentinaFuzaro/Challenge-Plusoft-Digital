package br.com.fiap.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challenge.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
    Optional<Usuario> findByEmail(String username);
}