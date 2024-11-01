package com.example.listacomprasapi.entity;

import com.example.listacomprasapi.model.IconModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String biblioteca;
    private String cor;

    public IconEntity(IconModel iconModel) {
        this.nome = iconModel.getNome();
        this.biblioteca = iconModel.getBiblioteca();
        this.cor = iconModel.getCor();
    }
}
