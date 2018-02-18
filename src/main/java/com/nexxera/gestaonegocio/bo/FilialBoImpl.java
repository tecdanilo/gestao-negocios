package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Filial;
import com.nexxera.gestaonegocio.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialBoImpl implements FilialBo {

    @Autowired
    FilialRepository filialRepository;

    @Override
    public List<Filial> findAll(){
        return filialRepository.findAll();
    }

    @Override
    public Filial findOne(Long id){
        return  filialRepository.findOne(id);
    }
}
