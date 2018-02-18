package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.ContasPagar;
import com.nexxera.gestaonegocio.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasPagarBoImpl implements ContasPagarBo {

    @Autowired
    ContasPagarRepository contasPagarRepository;

    @Override
    public ContasPagar save(ContasPagar conta){
        return contasPagarRepository.save(conta);
    }

    @Override
    public List<ContasPagar> listAll(){
        return contasPagarRepository.findAll(new Sort("dataVencimento desc"));
    }

    @Override
    public ContasPagar findOne(Long numdoc){
        return contasPagarRepository.findOne(numdoc);
    }

    @Override
    public void delete(Long numdoc){
        contasPagarRepository.delete(numdoc);
    }
}
