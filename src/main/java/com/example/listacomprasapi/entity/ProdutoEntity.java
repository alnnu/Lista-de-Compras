package com.example.listacomprasapi.entity;

import com.example.listacomprasapi.model.ProdutoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    private IconEntity icon;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<ListaProdutoEntity> listaProduto;

    public ProdutoEntity(ProdutoModel produtoModel) {
        nome = produtoModel.getNome();
        descricao = produtoModel.getDescricao();
        icon = produtoModel.getIcon();
        listaProduto = produtoModel.getListaProduto();
    }
}
