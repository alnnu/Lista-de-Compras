package com.example.listacomprasapi.entity;

import com.example.listacomprasapi.model.ListaComprasModel;
import com.example.listacomprasapi.model.ProdutoModel;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@AllArgsConstructor
@Data
public class ListaComprasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date criacao;

    @OneToMany(mappedBy = "lista", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ListaProdutoEntity> listaProduto;

    private ListaStatus status;

    public ListaComprasEntity(ListaComprasModel model) {
        criacao = new Date();
        listaProduto = new ArrayList<>();
        status = ListaStatus.valueOf("aberta");
    }
    public ListaComprasEntity() {
        criacao = new Date();
        listaProduto = new ArrayList<>();
        status = ListaStatus.valueOf("aberta");
    }



}
