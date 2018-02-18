package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Estado;

import java.util.List;

public interface EstadoBo {
    List<Estado> findAll();

    Estado findOne(Long id);
}
