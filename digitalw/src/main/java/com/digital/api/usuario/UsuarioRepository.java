package com.digital.api.usuario;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digital.api.usuario.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long>{

	Usuario findByEmailAndSenha(String email, String senha);
	
	Optional<Usuario> findById(Long id);
}