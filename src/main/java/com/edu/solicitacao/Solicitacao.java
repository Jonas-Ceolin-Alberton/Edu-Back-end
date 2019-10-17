package com.edu.solicitacao;

import com.edu.usuario.Usuario;

import javax.persistence.*;

@Entity
public class Solicitacao {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;

    @OneToOne(fetch = FetchType.EAGER)
    private Usuario solicitante;

    @Enumerated(EnumType.STRING)
    private TipoSolicitacao tipoSolicitacao;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao statusSolicitacao;

    public enum  TipoSolicitacao {
        SOLICITACAO_CRIADOR, SOLICITACAO_PUBLICACAO
    }

    public enum StatusSolicitacao {
        ACEITA, NEGADA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public StatusSolicitacao getStatusSolicitacao() {
        return statusSolicitacao;
    }

    public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
        this.statusSolicitacao = statusSolicitacao;
    }
}
