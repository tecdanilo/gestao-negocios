package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Cidade;

import java.util.List;

public interface CidadeBo {

    /**
     * Lista todas cidades
     * @return
     */
    List<Cidade> findAll();

    /**
     * Encontra uma cidade pelo id;
     * @param id
     * @return cidade com o id correspondente
     */
    Cidade findOne(Long id);
}
