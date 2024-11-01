package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.IconEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconModel {
    private String nome;
    private String biblioteca;
    private String cor;

    public IconModel(IconEntity iconEntity) {
        this.nome = iconEntity.getNome();
        this.biblioteca = iconEntity.getBiblioteca();
        this.cor = iconEntity.getCor();
    }
}
