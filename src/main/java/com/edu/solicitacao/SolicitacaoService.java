package com.edu.solicitacao;

import com.edu.atividade.AtividadeService;
import com.edu.solicitacao.enums.StatusSolicitacao;
import com.edu.solicitacao.enums.TipoSolicitacao;
import com.edu.usuario.Usuario;
import com.edu.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    AtividadeService atividadeService;

    public Solicitacao criarSolicitacaoRoleCreator(Usuario usuario) throws Exception {
        Usuario user = usuarioService.findByUsername(usuario.getUsername());

        if (Objects.isNull(user)) throw new Exception("erro");

        Solicitacao solicitacao = Solicitacao.builder()
                .solicitante(user)
                .tipoSolicitacao(TipoSolicitacao.CRIADOR)
                .descricao("Solicitação de permissão criador")
                .statusSolicitacao(StatusSolicitacao.PENDENTE)
                .dataSolicitacao(LocalDate.now())
                .build();

        return solicitacaoRepository.save(solicitacao);
    }

    public Solicitacao permitirCriador(Solicitacao solicitacao) throws Exception {
        solicitacao =  solicitacaoRepository.findById(solicitacao.getId()).get();

        if(Objects.isNull(solicitacao)) throw  new Exception("Solicitação não encontrada");

        solicitacao.setStatusSolicitacao(StatusSolicitacao.ACEITA);
        solicitacao = solicitacaoRepository.save(solicitacao);
        usuarioService.adicionarPermissaoCreator(solicitacao.getSolicitante());

        return solicitacao;
    }

    public Iterable<Solicitacao> buscarPorStatus(StatusSolicitacao statusSolicitacao) {
        return solicitacaoRepository.findByStatusSolicitacao(statusSolicitacao);
    }
}
