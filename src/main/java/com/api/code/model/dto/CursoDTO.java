package com.api.code.model.dto;

import com.api.code.model.entities.Curso;

import java.util.UUID;

public class CursoDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private String urlIcon;

    public CursoDTO() {
    }

    public CursoDTO(Curso entity) {
        id = entity.getId();
        nome =  entity.getNome();
        descricao =  entity.getDescricao();
        urlIcon =  entity.getUrlIcon();
//        entity.getModulos().forEach(item -> getModulos().add(new ModuloDTO(item)));
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }


}
