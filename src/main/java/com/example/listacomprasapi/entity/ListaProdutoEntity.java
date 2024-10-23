package com.example.listacomprasapi.entity;


import com.example.listacomprasapi.model.ListaProdutoModel;
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
}
