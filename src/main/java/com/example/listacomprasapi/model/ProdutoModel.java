package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.ListaProdutoEntity;
import com.example.listacomprasapi.entity.ProdutoEntity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    private String nome;
    private String descricao;

    private List<ListaProdutoEntity> listaProduto;

    public ProdutoModel(ProdutoEntity entity) {
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.listaProduto = entity.getListaProduto();
    }
}
