package com.example.listacomprasapi.repository;

import com.example.listacomprasapi.entity.ListaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaProdutoRepository extends JpaRepository<ListaProdutoEntity, Long> {
}
