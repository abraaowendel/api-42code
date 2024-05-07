package com.api.code.services;

import com.api.code.model.dto.AulaDTO;
import com.api.code.repositories.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    private final AulaRepository repository;

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }
    public List<AulaDTO> trazerCursos(){
        return repository.findAll().stream().map(AulaDTO::new).toList();
    }

}
