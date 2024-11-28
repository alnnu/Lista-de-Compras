package com.example.listacomprasapi.service.imp;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.entity.ListaProdutoEntity;
import com.example.listacomprasapi.entity.ProdutoEntity;
import com.example.listacomprasapi.model.ListaComprasModel;
import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import com.example.listacomprasapi.repository.ListaCompraRepository;
import com.example.listacomprasapi.repository.ListaProdutoRepository;
import com.example.listacomprasapi.repository.ProdutoRepository;
import com.example.listacomprasapi.service.ListaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class ListaServiceImp implements ListaService {

    private final ListaCompraRepository listaCompraRepository;

    private final ProdutoRepository produtoRepository;

    private final ListaProdutoRepository listaProdutoRepository;

    @Override
    public ResponseEntity<List<ListaComprasModel>> findAll() {
        List<ListaComprasEntity> listaComprasEntities = listaCompraRepository.findAll();

        List<ListaComprasModel> listaComprasModels= new ArrayList<>();

        for (ListaComprasEntity entity : listaComprasEntities) {
            listaComprasModels.add(new ListaComprasModel(entity));
        }

        return new ResponseEntity<>(listaComprasModels, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListaComprasModel> findById(Long id) {
        ListaComprasEntity entity = listaCompraRepository.findById(id).orElse(null);
        ListaComprasModel listaComprasModel;

        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            listaComprasModel = new ListaComprasModel(entity);
            return new ResponseEntity<>(listaComprasModel, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<ListaComprasModel> findAtiva() {

        ListaComprasEntity listaComprasEntity = listaCompraRepository.findByStatus(ListaStatus.aberta);
        ListaComprasModel listaComprasModel;

        if (listaComprasEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            listaComprasModel = new ListaComprasModel(listaComprasEntity);
            return new ResponseEntity<>(listaComprasModel, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> save(ListaComprasModel listaComprasModel) {

        ListaComprasEntity listaComprasEntity = listaCompraRepository.findByStatus(ListaStatus.aberta);


        if (listaComprasEntity == null) {
            listaComprasEntity = new ListaComprasEntity(listaComprasModel);
            listaCompraRepository.save(listaComprasEntity);


            return new ResponseEntity<>(new ListaComprasModel(listaComprasEntity), HttpStatus.CREATED);
        } else {
            Map<String, String> errors = new HashMap<>();

            errors.put("Error", "Ja possui uma lista ativa");

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> addProduto(Long listaId, ProdutoModel produtoModel) {
        ListaComprasEntity listaComprasEntity = listaCompraRepository.findById(listaId).orElse(null);
        Map<String, String> msg = new HashMap<>();

        if (listaComprasEntity == null) {


            msg.put("Error", "Lista Não existente");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        } else {
            AtomicReference<Byte> flag = new AtomicReference<>((byte) 0);

            ProdutoEntity produtoEntity = produtoRepository.findById(produtoModel.getId()).orElse(null);

            ListaComprasModel listaComprasModel = new ListaComprasModel(listaComprasEntity);

            listaComprasModel.getListaProduto().forEach(listaProdutoEntity -> {
                if (listaProdutoEntity.getProduto().getId().equals(produtoModel.getId())) {
                    listaProdutoEntity.setQuantidade(listaProdutoEntity.getQuantidade() + 1);
                    flag.set((byte) 1);
                    System.out.println(flag);
                }
            });

            if(flag.get() == 0){
                listaComprasModel.getListaProduto().add(new ListaProdutoEntity(listaComprasEntity, produtoEntity));
            }

            listaCompraRepository.save(listaComprasEntity);

            msg.put("msg", "produto adicionado");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> removeProduto(Long listaId, ProdutoModel produtoModel) {
        ListaComprasEntity listaComprasEntity = listaCompraRepository.findById(listaId).orElse(null);
        Map<String, String> msg = new HashMap<>();

        if (listaComprasEntity == null) {


            msg.put("Error", "Lista Não existente");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        } else {
            byte flag = 0;
            int index = 0;
            ProdutoEntity produtoEntity = produtoRepository.findById(produtoModel.getId()).orElse(null);

            if (produtoEntity != null) {
                ListaComprasModel listaComprasModel = new ListaComprasModel(listaComprasEntity);


                for(ListaProdutoEntity lista : listaComprasEntity.getListaProduto()){
                    if (lista.getProduto().getId().equals(produtoModel.getId())) {
                        if (lista.getQuantidade() > 1) {
                            lista.setQuantidade(lista.getQuantidade() - 1);
                        } else {
                           index = listaComprasModel.getListaProduto().indexOf(lista);
                           flag = 1;
                        }
                    }
                }
                if(flag == 1){

                    listaComprasEntity.getListaProduto().remove(index);
                }

                listaCompraRepository.save(listaComprasEntity);

                msg.put("msg", "produto removido ");
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }else {
                msg.put("Error", "Produto Não existente");
                return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
            }

        }
    }


}
