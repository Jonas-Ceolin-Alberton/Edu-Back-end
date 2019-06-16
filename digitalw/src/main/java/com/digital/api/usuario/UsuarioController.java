package com.digital.api.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
