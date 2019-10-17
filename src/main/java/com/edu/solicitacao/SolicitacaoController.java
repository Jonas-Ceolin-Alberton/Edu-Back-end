package com.edu.solicitacao;

import com.edu.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/solicitacao")
@CrossOrigin
public class SolicitacaoController {

    @Autowired
    SolicitacaoService solicitacaoService;

    @PostMapping("/criador")
    public Solicitacao solicitarRoleCreator(@RequestBody Usuario usuario) throws Exception {
        return solicitacaoService.criarSolicitacaoCreator(usuario);
    }

    @GetMapping("/admin")
    public Iterable<Solicitacao> findAll() {
        return solicitacaoService.buscarTodos();
    }
}
