package com.nexxera.gestaonegocio.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter @Setter @ToString
public class ContasPagar {

    @Id
    private Long numdoc;
    @OneToOne
    private Filial filial;
    @OneToOne
    private Fornecedor fornecedor;
    private Date dataLancamento;
    private Date dataVencimento;
    private BigDecimal valor;
    private String descricao;
    private String observacao;
    private Date dataBaixa;
    @OneToOne
    private Usuario usuarioLancamento;
    @OneToOne
    private Usuario usuarioBaixa;

}
