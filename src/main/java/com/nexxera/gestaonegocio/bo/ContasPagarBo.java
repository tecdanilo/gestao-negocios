package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.dto.ContasPagarDTO;
import com.nexxera.gestaonegocio.entity.ContasPagar;

import java.util.List;

public interface ContasPagarBo {
    ContasPagar save(ContasPagar conta);

    List<ContasPagar> findAll();

    ContasPagar findOne(Long numdoc);

    void delete(Long numdoc);

    ContasPagar parseContasPagar(ContasPagarDTO conta);
}
