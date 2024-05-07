package com.api.code.services;

import com.api.code.model.dto.CursoDTO;
import com.api.code.model.dto.ModuloDTO;
import com.api.code.repositories.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {
    private final ModuloRepository repository;

    public ModuloService(ModuloRepository repository) {
        this.repository = repository;
    }
    public List<ModuloDTO> trazerModulos(){
        return repository.findAll().stream().map(ModuloDTO::new).toList();
    }

}
