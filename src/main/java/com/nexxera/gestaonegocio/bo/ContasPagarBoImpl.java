package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.dto.ContasPagarDTO;
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

    @Autowired
    FilialBoImpl filialBo;

    @Autowired
    FornecedorBo fornecedorBo;

    @Autowired
    UsuarioBo usuarioBo;

    @Override
    public ContasPagar save(ContasPagar conta){
        return contasPagarRepository.save(conta);
    }

    @Override
    public List<ContasPagar> findAll(){
        return contasPagarRepository.findAll();
    }

    @Override
    public ContasPagar findOne(Long numdoc){
        return contasPagarRepository.findOne(numdoc);
    }

    @Override
    public void delete(Long numdoc){
        contasPagarRepository.delete(numdoc);
    }

    @Override
    public ContasPagar parseContasPagar(ContasPagarDTO conta){
        if (conta == null){
            return null;
        }
        ContasPagar cp = new ContasPagar();
        cp.setNumdoc(conta.getNumdoc());
        cp.setFilial( conta.getFilialId() != null ? filialBo.findOne(conta.getFilialId()) : null );
        cp.setFornecedor( conta.getFornecedorId() != null ? fornecedorBo.findById(conta.getFornecedorId()) : null );
        cp.setDataLancamento(conta.getDataLancamento());
        cp.setDataVencimento(conta.getDataVencimento());
        cp.setValor(conta.getValor());
        cp.setDescricao(conta.getDescricao());
        cp.setObservacao(conta.getObservacao());
        cp.setDataBaixa(conta.getDataBaixa());
        cp.setUsuarioLancamento(conta.getUsuarioLancamentoId() != null ? usuarioBo.findOne(conta.getUsuarioLancamentoId()) : null);
        cp.setUsuarioBaixa(conta.getUsuarioBaixaId() != null ? usuarioBo.findOne(conta.getUsuarioBaixaId()) : null);
        return cp;
    }
}
