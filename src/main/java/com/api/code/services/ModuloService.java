package com.api.code.services;

import com.api.code.model.dto.ModuloDTO;
import com.api.code.model.entities.Modulo;
import com.api.code.repositories.ModuloRepository;
import com.api.code.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ModuloService {
    private final ModuloRepository repository;

    public ModuloService(ModuloRepository repository) {
        this.repository = repository;
    }
    public Page<ModuloDTO> listarModulos(Pageable pageable){
        return repository.findAll(pageable).map(ModuloDTO::new);
    }
    @Transactional(readOnly = true)
    public ModuloDTO listarModuloPorID(Long id) {
        return repository.findById(id)
                .map(ModuloDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Modulo não encontrado."));
    }
    @Transactional
    public ModuloDTO criarModulo(ModuloDTO dto) {
        var entity = new Modulo();
        BeanUtils.copyProperties(dto, entity);
        repository.save(entity);
        return new ModuloDTO(entity);
    }
    @Transactional
    public ModuloDTO atualizarModulo(Long id, ModuloDTO dto) {
        try{
            var entity = repository.getReferenceById(id);
            BeanUtils.copyProperties(dto, entity);
            repository.save(entity);
            return new ModuloDTO(entity);
        }
        catch (EntityNotFoundException exception){
            throw new ResourceNotFoundException("Modulo não encontrado.");
        }
    }
}
