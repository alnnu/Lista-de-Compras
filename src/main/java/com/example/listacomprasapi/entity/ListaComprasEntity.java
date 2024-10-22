package com.example.listacomprasapi.entity;

import com.example.listacomprasapi.model.ListaComprasModel;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private Long id;

    private Date criação;

    private String nome;

    @ManyToMany
    private List<ProdutoEntity> produtos;

    private ListaStatus status;

    public ListaComprasEntity(ListaComprasModel model) {
        criação = new Date();
        nome = model.getNome();
        produtos = model.getProdutos();
        status = ListaStatus.valueOf("aberta");
    }
}
