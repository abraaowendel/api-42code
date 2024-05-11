package com.api.code.services;

import com.api.code.model.dto.CursoDTO;
import com.api.code.model.entities.Curso;
import com.api.code.repositories.CursoRepository;
import com.api.code.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<CursoDTO> listarCursos(Pageable pageable){
        return repository.findAll(pageable).map(CursoDTO::new);
    }
    @Transactional(readOnly = true)
    public CursoDTO listarCursoPorID(Long id) {
        return repository.findById(id)
                .map(CursoDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado."));
    }
    @Transactional
    public CursoDTO criarCurso(CursoDTO dto) {
        var entity = new Curso();
        BeanUtils.copyProperties(dto, entity);
        repository.save(entity);
        return new CursoDTO(entity);
    }
    @Transactional
    public CursoDTO atualizarCurso(Long id, CursoDTO dto) {
        try{
            var entity = repository.getReferenceById(id);
            BeanUtils.copyProperties(dto, entity);
            repository.save(entity);
            return new CursoDTO(entity);
        }
        catch (EntityNotFoundException exception){
            throw new ResourceNotFoundException("Curso não encontrado.");
        }
    }
}
