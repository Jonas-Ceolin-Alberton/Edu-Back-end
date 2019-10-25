package com.edu.atividade.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/aula")
@CrossOrigin
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping("/creator")
    public Aula cadastrar(@RequestBody() Aula aula) {
        return aulaService.salvar(aula);
    }
}
