package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Cidade;
import com.nexxera.gestaonegocio.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeBoImpl implements CidadeBo {

    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    @Override
    public Cidade findOne(Long id){
        return  cidadeRepository.findOne(id);
    }
}
