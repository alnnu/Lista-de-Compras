package com.example.listacomprasapi.entity;

import com.example.listacomprasapi.model.ListaComprasModel;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListaComprasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date criação;

    private String nome;

    @OneToMany(mappedBy = "lista", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ListaProdutoEntity> listaProduto;

    private ListaStatus status;

    public ListaComprasEntity(ListaComprasModel model) {
        criação = new Date();
        nome = model.getNome();
        listaProduto = model.getListaProduto();
        status = ListaStatus.valueOf("aberta");
    }
}
