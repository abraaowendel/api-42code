package com.api.code.controllers;

import com.api.code.model.dto.ModuloDTO;
import com.api.code.services.ModuloService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/modulos")
public class ModuloController {
    private final ModuloService service;

    public ModuloController(ModuloService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ModuloDTO>> listarModulos(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarModulos(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModuloDTO> listarModuloPorID(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarModuloPorID(id));
    }
    @PostMapping
    public ResponseEntity<ModuloDTO> criarModulo(@RequestBody @Valid ModuloDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.criarModulo(dto));
    }
    @PutMapping
    public ResponseEntity<ModuloDTO> atualizarModulo(@PathVariable Long id, @RequestBody @Valid ModuloDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarModulo(id, dto));
    }
}
