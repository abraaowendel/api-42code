package com.api.code.model.dto;

import com.api.code.model.entities.Aula;
import com.api.code.model.entities.Curso;
import com.api.code.model.entities.Modulo;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class ModuloDTO {
    private Long id;
    @NotBlank(message = "Nome inválido.")
    private String nome;
    private CursoMinDTO curso;
    private List<Aula> aulas = new ArrayList<>();

    public ModuloDTO() {
    }

    public ModuloDTO(Modulo entity) {
        id = entity.getId();
        nome = entity.getNome();
        aulas = entity.getAulas();
        setCurso(new CursoMinDTO(entity.getId(), entity.getNome()));
    }

//    FALTA ADICIONAR AS AULAS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CursoMinDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoMinDTO curso) {
        this.curso = curso;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Aula> getAulas() {
        return aulas;
    }
}
