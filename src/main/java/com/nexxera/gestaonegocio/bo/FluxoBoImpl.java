package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Fluxo;
import com.nexxera.gestaonegocio.repository.FluxoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FluxoBoImpl implements FluxoBo {

    @Autowired
    FluxoRepository fluxoRepository;

    @Override
    public List<Fluxo> findAll(){
        return fluxoRepository.findAll();
    }
}
