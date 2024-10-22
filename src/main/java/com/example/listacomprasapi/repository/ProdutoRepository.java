package com.example.listacomprasapi.repository;

import com.example.listacomprasapi.entity.ProdutoEntity;
import com.example.listacomprasapi.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
