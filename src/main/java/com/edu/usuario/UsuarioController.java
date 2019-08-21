package com.edu.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/{username}")
    public Usuario listarPorId(@PathVariable(name = "username") String username) {
        return this.usuarioService.buscarPorUserName(username);
    }
//
//    @PostMapping()
//    public Usuario atualizar(@RequestBody Usuario usuario) {
//        return this.usuarioService.atualizar(usuario);
//    }

    @PostMapping()
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return this.usuarioService.cadastrar(usuario);
    }
}
