package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.ContasPagar;

import java.util.List;

public interface ContasPagarBo {
    ContasPagar save(ContasPagar conta);

    List<ContasPagar> listAll();

    ContasPagar findOne(Long numdoc);

    void delete(Long numdoc);
}
