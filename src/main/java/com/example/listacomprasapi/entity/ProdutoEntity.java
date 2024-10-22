package com.example.listacomprasapi.entity;

import com.example.listacomprasapi.model.ProdutoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ProdutoEntity(ProdutoModel produtoModel) {
        nome = produtoModel.getNome();
        descricao = produtoModel.getDescricao();
    }
}
