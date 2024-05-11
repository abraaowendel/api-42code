package com.api.code.controllers;

import com.api.code.model.dto.AulaDTO;
import com.api.code.services.AulaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/aulas")
public class AulaController {
    private final AulaService service;

    public AulaController(AulaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<AulaDTO>> listarAulas(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarAulas(pageable));
    }

    @PostMapping
    public ResponseEntity<AulaDTO> criarAula(@RequestBody @Valid AulaDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.criarAula(dto));
    }
    @PutMapping
    public ResponseEntity<AulaDTO> atualizarAula(@PathVariable Long id, @RequestBody @Valid AulaDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAula(id, dto));
    }
}
