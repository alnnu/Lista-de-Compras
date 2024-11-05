package com.example.listacomprasapi.entity;


import com.example.listacomprasapi.model.ListaProdutoModel;
import com.example.listacomprasapi.model.ProdutoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Lista_Produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private ListaComprasEntity lista;

    @ManyToOne
    private ProdutoEntity produto;



    private int quantidade;


    public ListaProdutoEntity(ListaProdutoModel listaProdutoModel) {
        this.lista = listaProdutoModel.getLista();
        this.produto = listaProdutoModel.getProduto();
        this.quantidade = listaProdutoModel.getQuantidade();
    }

    public ListaProdutoEntity(ListaComprasEntity listaComprasEntity, ProdutoEntity produtoEntity) {
        this.lista = listaComprasEntity;
        this.produto = produtoEntity;
        this.quantidade = 1;
    }


}
