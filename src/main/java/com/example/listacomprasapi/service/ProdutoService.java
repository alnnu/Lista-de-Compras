package com.example.listacomprasapi.service;

import com.example.listacomprasapi.entity.ProdutoEntity;
import com.example.listacomprasapi.model.ProdutoModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {
    public ResponseEntity<List<ProdutoModel>> findAll();
    public ResponseEntity<ProdutoModel> findById(Long id);
}
