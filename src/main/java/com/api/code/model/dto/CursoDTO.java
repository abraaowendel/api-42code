package com.api.code.model.dto;

import com.api.code.model.entities.Curso;
import com.api.code.model.entities.Modulo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoDTO {
    private Long id;
    @NotBlank(message = "Nome inválido.")
    private String nome;
    @NotBlank(message = "Descrição inválida.")
    private String descricao;
    @NotBlank(message = "Url inválido.")
    private String urlIcon;
    @JsonIgnore
    private List<ModuloDTO> modulos = new ArrayList<>();
    public CursoDTO() {
    }

    public CursoDTO(Curso entity) {
        id = entity.getId();
        nome =  entity.getNome();
        descricao =  entity.getDescricao();
        urlIcon =  entity.getUrlIcon();
        modulos = entity.getModulos().stream()
                .map(ModuloDTO::new)
                .collect(Collectors.toList());    }
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

    public List<ModuloDTO> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloDTO> modulos) {
        this.modulos = modulos;
    }
}
