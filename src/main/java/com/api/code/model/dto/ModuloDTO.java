package com.api.code.model.dto;

import com.api.code.model.entities.Modulo;

import java.util.UUID;

public class ModuloDTO {
    private UUID id;
    private String nome;

    public ModuloDTO() {
    }

    public ModuloDTO(Modulo entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
//    FALTA ADICIONAR AS AULAS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
