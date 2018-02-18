package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Cidade;

import java.util.List;

public interface CidadeBo {
    List<Cidade> findAll();

    Cidade findOne(Long id);
}
