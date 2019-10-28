package com.edu.atividade.certificado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CertificadoService {

    @Autowired
    CertificadoRepository certificadoRepository;

    public Iterable<Certificado> buscarTodos() {
       return certificadoRepository.findAll();
    }

    public Certificado buscarPorId(Long id) {
        return certificadoRepository.findById(id).get();
    }

    public List<Certificado> buscarTodosPorUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return certificadoRepository.findByUsuarioUsername(username);
    }


}
