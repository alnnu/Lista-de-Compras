package com.example.listacomprasapi.controller;

import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ControllerAdvice
@RequestMapping("/api/v1/produto")
public class produtoController {

    private final ProdutoService produtoService;

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoModel>> findAll(){
        return produtoService.findAll();
    }

    @GetMapping("/{produto_id}")
    public ResponseEntity<ProdutoModel> findById(@PathVariable Long produto_id){
        return produtoService.findById(produto_id);
    }
}
