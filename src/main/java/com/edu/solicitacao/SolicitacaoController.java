package com.edu.solicitacao;

import com.edu.solicitacao.enums.StatusSolicitacao;
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
        return solicitacaoService.criarSolicitacaoRoleCreator(usuario);
    }

    @GetMapping("/admin/{status}")
    public Iterable<Solicitacao> buscarPorSatus(@PathVariable StatusSolicitacao status) {
        return solicitacaoService.buscarPorStatus(status);
    }

    @PostMapping("/admin/permitir-criador")
    public Solicitacao permitirCriador(@RequestBody Solicitacao solicitacao) throws Exception {
        return solicitacaoService.permitirCriador(solicitacao);
    }


}
