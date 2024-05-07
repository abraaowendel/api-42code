package com.api.code.services;

import com.api.code.model.dto.CursoDTO;
import com.api.code.repositories.CursoRepository;
import com.api.code.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }
    public List<CursoDTO> trazerCursos(){
        return repository.findAll().stream().map(CursoDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public CursoDTO trazerCursoPorID(UUID id) {
        return repository.findById(id)
                .map(CursoDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrado."));
    }

}
