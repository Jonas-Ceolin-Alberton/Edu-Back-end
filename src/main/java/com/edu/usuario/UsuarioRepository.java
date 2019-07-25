package com.edu.usuario;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long>{

    Usuario findByEmailAndSenha(String email, String senha);

    Optional<Usuario> findById(Long id);
}