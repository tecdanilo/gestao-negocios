package com.nexxera.gestaonegocio.dto;

import com.nexxera.gestaonegocio.entity.ContasPagar;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @ToString
public class ContasPagarDTO implements Serializable{

    private Long numdoc;
    private Long filialId;
    private Long fornecedorId;
    private Date dataLancamento;
    private Date dataVencimento;
    private BigDecimal valor;
    private String descricao;
    private String observacao;
    private Date dataBaixa;
    private Long usuarioLancamentoId;
    private Long usuarioBaixaId;

    public static ContasPagarDTO parseContasPagarDTO(ContasPagar conta){
        if (conta == null){
            return null;
        }
        ContasPagarDTO cp = new ContasPagarDTO();
        cp.setNumdoc(conta.getNumdoc());
        cp.setFilialId( conta.getFilial() != null ? conta.getFilial().getId() : null );
        cp.setFornecedorId(conta.getFornecedor() != null ? conta.getFornecedor().getId() : null );
        cp.setDataLancamento(conta.getDataLancamento());
        cp.setDataVencimento(conta.getDataVencimento());
        cp.setValor(conta.getValor());
        cp.setDescricao(conta.getDescricao());
        cp.setObservacao(conta.getObservacao());
        cp.setDataBaixa(conta.getDataBaixa());
        cp.setUsuarioLancamentoId( conta.getUsuarioLancamento() != null ? conta.getUsuarioLancamento().getId() : null);
        cp.setUsuarioBaixaId( conta.getUsuarioBaixa() != null ? conta.getUsuarioBaixa().getId() : null);
        return cp;
    }

}
