package com.edu.atividade;

import com.edu.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @ManyToOne
    private Usuario criador;


}
