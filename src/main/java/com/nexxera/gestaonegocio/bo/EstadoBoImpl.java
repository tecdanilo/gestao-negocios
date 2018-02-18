package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Estado;
import com.nexxera.gestaonegocio.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoBoImpl implements EstadoBo {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    @Override
    public Estado findOne(Long id){
        return  estadoRepository.findOne(id);
    }
}
