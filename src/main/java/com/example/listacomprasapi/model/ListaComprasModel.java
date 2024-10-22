package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.entity.ProdutoEntity;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaComprasModel {

    private Date criação;

    private String nome;

    private List<ProdutoEntity> produtos;

    private ListaStatus status;

    public ListaComprasModel(ListaComprasEntity entity) {
        nome = entity.getNome();
        produtos = entity.getProdutos();
        status = entity.getStatus();
    }
}
