package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Filial;

import java.util.List;

public interface FilialBo {
    List<Filial> findAll();

    Filial findOne(Long id);
}
