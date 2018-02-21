package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.dto.ContasPagarDTO;
import com.nexxera.gestaonegocio.entity.ContasPagar;

import java.util.List;


public interface ContasPagarBo {

    /**
     * salva  ou atualiza uma conta
     * @param conta - entidade conta à ser persistida
     * @return
     */
    ContasPagar save(ContasPagar conta);

    /**
     * Lista todas contas
     * @return lista de todas contas
     */
    List<ContasPagar> findAll();

    /**
     * Encontra todas contas de uma determinada filial
     * @param filialId - Código da Filial
     * @return todas contas lançadas na filial
     */
    List<ContasPagar> findAllByFilialId(Long filialId);

    /**
     * Encontra uma conta
     * @param numdoc - número do documento
     * @return conta referente ao número do documento
     */
    ContasPagar findOne(Long numdoc);

    /**
     * Remove a conta pelo número do documento
     * @param numdoc - número do documento
     */
    void delete(Long numdoc);

    /**
     * Converte o objeto DTO de contas para a Entidade de persistência.
     * @param conta - DTO contendo a representação da entidade de banco
     * @return Objeto Entidade.
     */
    ContasPagar parseContasPagar(ContasPagarDTO conta);
}
