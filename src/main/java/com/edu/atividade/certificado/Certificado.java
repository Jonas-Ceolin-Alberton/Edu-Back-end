package com.edu.atividade.certificado;

import com.edu.atividade.Atividade;
import com.edu.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Certificado {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToOne
    private Atividade atividade;

    @NotNull
    @OneToOne
    private Usuario usuario;

    private boolean criador;
}
