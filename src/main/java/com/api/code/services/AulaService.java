package com.api.code.services;

import com.api.code.model.dto.AulaDTO;
import com.api.code.model.entities.Aula;
import com.api.code.repositories.AulaRepository;
import com.api.code.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AulaService {
    private final AulaRepository repository;

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }
    public Page<AulaDTO> listarAulas(Pageable pageable){
        return repository.findAll(pageable).map(AulaDTO::new);
    }

    @Transactional
    public AulaDTO criarAula(AulaDTO dto) {
        var entity = new Aula();
        BeanUtils.copyProperties(dto, entity);
        repository.save(entity);
        return new AulaDTO(entity);
    }
    @Transactional
    public AulaDTO atualizarAula(Long id, AulaDTO dto) {
        try{
            var entity = repository.getReferenceById(id);
            BeanUtils.copyProperties(dto, entity);
            repository.save(entity);
            return new AulaDTO(entity);
        }
        catch (EntityNotFoundException exception){
            throw new ResourceNotFoundException("Aula não encontrada.");
        }
    }


}

