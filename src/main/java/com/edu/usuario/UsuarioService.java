package com.edu.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorUserName(String userName) {
        return this.usuarioRepository.findByUsername(userName);
}

    public Usuario atualizar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setPassword(this.bcryptPassword(usuario.getPassword()));
        return this.usuarioRepository.save(usuario);
    }

    private String bcryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}