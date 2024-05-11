package com.api.code.controllers;

import com.api.code.model.dto.CursoDTO;
import com.api.code.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<CursoDTO>> listarCursos(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarCursos(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> listarCursoPorID(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarCursoPorID(id));
    }
    @PostMapping
    public ResponseEntity<CursoDTO> criarCurso(@RequestBody @Valid CursoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.criarCurso(dto));
    }
    @PutMapping
    public ResponseEntity<CursoDTO> atualizarCurso(@PathVariable Long id, @RequestBody @Valid CursoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarCurso(id, dto));
    }
}
