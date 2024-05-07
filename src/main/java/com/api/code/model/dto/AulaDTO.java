package com.api.code.model.dto;

import com.api.code.model.entities.Aula;

import java.util.UUID;

public class AulaDTO {
    private UUID id;
    private String titulo;
    private String url;
    private boolean visto;

    public AulaDTO() {
    }

    public AulaDTO(Aula entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        url = entity.getUrl();
        visto = entity.isVisto();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}
