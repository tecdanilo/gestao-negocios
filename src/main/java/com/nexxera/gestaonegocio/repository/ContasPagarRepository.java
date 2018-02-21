package com.nexxera.gestaonegocio.repository;

import com.nexxera.gestaonegocio.entity.ContasPagar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContasPagarRepository extends JpaRepository<ContasPagar,Long> {

    public List<ContasPagar> findAllByFilialId(Long filialId);

}
