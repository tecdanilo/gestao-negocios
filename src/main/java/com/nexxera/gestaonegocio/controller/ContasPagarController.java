package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.entity.Cidade;
import com.nexxera.gestaonegocio.entity.ContasPagar;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import com.nexxera.gestaonegocio.repository.ContasPagarRepository;
import com.nexxera.gestaonegocio.util.ErrorsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contas/pagar")
public class ContasPagarController {

    private static Logger logger = LoggerFactory.getLogger(ContasPagarController.class);

    @Autowired
    ContasPagarRepository contasPagarRepository;

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<ResultadoServico<List<ContasPagar>>> listAll(){
        ResultadoServico<List<ContasPagar>> retorno = null;
        try{
            List<ContasPagar> contasPagar = contasPagarRepository.findAll();
            if ( contasPagar.isEmpty() ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null, ErrorsUtil.buildErrorsListWithPreData("Nenhum Fornecedor Cadastrado"));
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, contasPagar, null);
                return ResponseEntity.ok(retorno);
            }
        }catch (Exception e){
            logger.error("listAll",e);
            return ResponseEntity.status(500).body(
                    new ResultadoServico<>(
                            ApplicationConstants.RESULTADO_SERVICO_SERVER_ERROR, null,  ErrorsUtil.buildErrorsListWithPreData("Erro no processamento do servidor, se o problema persistir, contacte o administrador de sistemas")
                    )
            );
        }
    }
}
