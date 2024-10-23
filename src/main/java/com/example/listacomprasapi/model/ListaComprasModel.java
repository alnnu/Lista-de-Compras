package com.example.listacomprasapi.model;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.entity.ListaProdutoEntity;
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

    private List<ListaProdutoEntity> listaProduto;

    private ListaStatus status;

    public ListaComprasModel(ListaComprasEntity entity) {
        nome = entity.getNome();
        listaProduto = entity.getListaProduto();
        status = entity.getStatus();
    }
}
