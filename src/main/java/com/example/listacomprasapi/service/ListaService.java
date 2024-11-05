package com.example.listacomprasapi.service;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.model.ListaComprasModel;
import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListaService {
    public ResponseEntity<List<ListaComprasModel>> findAll();

    public ResponseEntity<ListaComprasModel> findById(Long id);

    public ResponseEntity<ListaComprasModel> findAtiva();

    public ResponseEntity<?> save(ListaComprasModel listaComprasModel);

    public ResponseEntity<?> addProduto(Long listaId, ProdutoModel produtoModel);

    public ResponseEntity<?> removeProduto(Long listaId, Long ProdutoId);
}
