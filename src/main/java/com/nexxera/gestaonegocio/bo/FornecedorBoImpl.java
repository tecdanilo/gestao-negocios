package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Fornecedor;
import com.nexxera.gestaonegocio.repository.FornecedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorBoImpl implements FornecedorBo {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> findAll(){
        return  fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor findById(Long id){
        return fornecedorRepository.findOne(id);
    }
}
