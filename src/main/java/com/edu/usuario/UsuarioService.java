package com.edu.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario autenticar(Usuario usuario) {
        String email = usuario.getEmail();
        String senha = usuario.getSenha();
        return this.usuarioRepository.findByEmailAndSenha(email, senha);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return this.usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }
}