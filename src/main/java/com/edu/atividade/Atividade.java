package com.edu.atividade;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Atividade {

    @Id
    private Long id;

    @NotBlank
    private String nome ;

    @NotBlank
    private String descricao;

}
