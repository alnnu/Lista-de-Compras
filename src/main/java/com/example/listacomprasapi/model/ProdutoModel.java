package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    private String nome;
    private String descricao;

    public ProdutoModel(ProdutoEntity entity) {
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }
}
