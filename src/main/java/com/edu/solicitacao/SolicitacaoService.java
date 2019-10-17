package com.edu.solicitacao;

import com.edu.usuario.Usuario;
import com.edu.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    @Autowired
    UsuarioService usuarioService;

    public Solicitacao criarSolicitacaoCreator(Usuario usuario) throws Exception {
        Usuario user = usuarioService.findByUsername(usuario.getUsername());

        if(Objects.isNull(user)) throw  new Exception("erro");

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDescricao("Solicitação de permissão criador");
        solicitacao.setSolicitante(user);
        solicitacao.setTipoSolicitacao(Solicitacao.TipoSolicitacao.SOLICITACAO_CRIADOR);
        return solicitacaoRepository.save(solicitacao);
    }

    public Iterable<Solicitacao> buscarTodos() {
        return solicitacaoRepository.findAll();
    }
}
