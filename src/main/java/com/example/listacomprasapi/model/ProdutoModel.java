package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.IconEntity;
import com.example.listacomprasapi.entity.ListaProdutoEntity;
import com.example.listacomprasapi.entity.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    protected Long id;
    private String nome;
    private String descricao;

    private IconEntity icon;


    @JsonIgnore
    private List<ListaProdutoEntity> listaProduto;



    public ProdutoModel(ProdutoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.icon = entity.getIcon();
        this.listaProduto = entity.getListaProduto();
    }
}
