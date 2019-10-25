package com.edu.atividade;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AtividadeRepository extends PagingAndSortingRepository<Atividade, Long> {

    List<Atividade> findByCriadorUsername(String username);
}
