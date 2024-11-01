package com.example.listacomprasapi.service.imp;

import com.example.listacomprasapi.entity.ProdutoEntity;
import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.repository.ProdutoRepository;
import com.example.listacomprasapi.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoServiceImp implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoEntity> produtoEntity = produtoRepository.findAll();

        List<ProdutoModel> produtoModels = new ArrayList<>();

        for (ProdutoEntity produto : produtoEntity) {
            produtoModels.add(new ProdutoModel(produto));
        }

        return new ResponseEntity<>(produtoModels, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProdutoModel> findById(Long id) {
        ProdutoModel model;
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);

        if (produtoEntity.isPresent()) {
            model = new ProdutoModel(produtoEntity.get());
            return new ResponseEntity<>(model, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
