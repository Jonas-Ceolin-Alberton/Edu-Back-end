package com.edu.solicitacao;

import com.edu.usuario.Usuario;

import javax.persistence.*;

@Entity
public class Solicitacao {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToOne(fetch = FetchType.EAGER)
    private Usuario solicitante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }
}
