package com.edu.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/{id}")
    public Optional<Usuario> listarPorId(@PathVariable(name = "id") Long id) {
        return this.usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @PostMapping(path= "/autenticar")
    public Usuario autenticar(@RequestBody Usuario usuario) {
        return this.usuarioService.autenticar(usuario);
    }
}
