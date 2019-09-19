package com.edu.atividade;

import com.edu.aula.Aula;
import com.edu.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Atividade {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titulo ;

    @NotBlank
    private String descricao;

    @NotNull
    @ManyToOne(fetch=FetchType.EAGER)
    private Usuario criador;

    @OneToMany
    private List<Aula> aulas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}
