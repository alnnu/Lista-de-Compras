package com.example.listacomprasapi.controller;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.model.ListaComprasModel;
import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.service.ListaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ControllerAdvice
@RequestMapping("/api/v1/lista")
public class ListaController {

    private final ListaService listaService;

    @GetMapping("/all")
    public ResponseEntity<List<ListaComprasModel>> findAll() {
        return listaService.findAll();
    }

    @GetMapping("/find/aberta")
    public ResponseEntity<ListaComprasModel> findAllaberta() {
        return listaService.findAtiva();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ListaComprasModel model ) {
        return listaService.save(model);
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<?> add(@RequestBody ProdutoModel model, @PathVariable Long id ) {
        return listaService.addProduto(id,model);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@RequestBody ProdutoModel model, @PathVariable Long id ) {
        return listaService.removeProduto(id,model);
    }
}
