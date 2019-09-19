package com.edu.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/atividade")
@CrossOrigin
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping()
    public Atividade cadastrar(@RequestBody() Atividade atividade) {
        Atividade atc = atividadeService.salvar(atividade);

        return  atc;
    }


}
