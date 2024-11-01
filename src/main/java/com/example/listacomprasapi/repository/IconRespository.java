package com.example.listacomprasapi.repository;

import com.example.listacomprasapi.entity.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRespository extends JpaRepository<IconEntity, Long> {
    public IconEntity findByNome(String nome);
}
