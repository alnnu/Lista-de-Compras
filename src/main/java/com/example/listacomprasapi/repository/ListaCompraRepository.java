package com.example.listacomprasapi.repository;

import com.example.listacomprasapi.entity.ListaComprasEntity;
import com.example.listacomprasapi.model.emuns.ListaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaCompraRepository extends JpaRepository<ListaComprasEntity, Long> {
    public ListaComprasEntity findByStatus(ListaStatus status);
}
