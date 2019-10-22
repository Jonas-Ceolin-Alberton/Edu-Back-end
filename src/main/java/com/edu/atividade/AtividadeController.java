package com.edu.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/atividade")
@CrossOrigin
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/creator")
    public Atividade cadastrar(@RequestBody() Atividade atividade) {
       return atividadeService.salvar(atividade);
    }

//    @GetMapping("/creator/{id}")
//    public Atividade cadastrar() {
//        return atividadeService.salvar(atividade);
//    }
}
