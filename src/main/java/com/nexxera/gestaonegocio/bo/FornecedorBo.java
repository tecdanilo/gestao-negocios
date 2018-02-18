package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Fornecedor;

import java.util.List;

public interface FornecedorBo {
    List<Fornecedor> findAll();

    Fornecedor findById(Long id);
}
