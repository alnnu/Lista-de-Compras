package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.entity.ListaProdutoEntity;
import com.example.listacomprasapi.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaProdutoModel {

    private ListaComprasEntity lista;

    private ProdutoEntity produto;


    private int quantidade;

    public ListaProdutoModel(ListaProdutoEntity listaProduto) {
        this.lista = listaProduto.getLista();
        this.produto = listaProduto.getProduto();
        this.quantidade = listaProduto.getQuantidade();
    }
}
