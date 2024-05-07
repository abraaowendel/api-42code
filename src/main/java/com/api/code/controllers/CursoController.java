package com.api.code.controllers;

import com.api.code.model.dto.CursoDTO;
import com.api.code.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.trazerCursos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> listarCursoPorID(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(service.trazerCursoPorID(id));
    }
}
