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
    private Long id;

    private Date criação;

    private List<ListaProdutoEntity> listaProduto;

    private ListaStatus status;

    public ListaComprasModel(ListaComprasEntity entity) {
        id = entity.getId();
        criação = entity.getCriação();
        listaProduto = entity.getListaProduto();
        status = entity.getStatus();
    }
}
