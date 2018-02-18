package com.nexxera.gestaonegocio.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @ToString
public class ContasPagar {
    private Long numdoc;
    private Filial filial;
    private Fornecedor fornecedor;
    private Date dataLancamento;
    private Date dataVencimento;
    private BigDecimal valor;
    private String descricao;
    private String observacao;
    private Date dataBaixa;
    private Usuario usuarioLancamento;
    private Usuario usuarioBaixa;
}
