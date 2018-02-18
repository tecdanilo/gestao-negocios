package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.bo.FornecedorBo;
import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.entity.Fornecedor;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor/")
public class FornecedorController {

    private static Logger logger = LoggerFactory.getLogger(FornecedorController.class);

    @Autowired
    FornecedorBo fornecedorBo;

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<ResultadoServico<List<Fornecedor>>> listAll(){
        ResultadoServico<List<Fornecedor>> retorno = null;
        try{
            List<Fornecedor> fornecedores = fornecedorBo.findAll();
            if ( fornecedores.isEmpty() ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null);
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, fornecedores);
                return ResponseEntity.ok(retorno);
            }
        }catch (Exception e){
            logger.error("listAll",e);
            return ResponseEntity.status(500).body(
                    new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_SERVER_ERROR, null)
            );
        }
    }

    @CrossOrigin
    @GetMapping(value = "{id}")
    public ResponseEntity<ResultadoServico<Fornecedor>> findOne(@PathVariable(value ="id") Long id){
        ResultadoServico<Fornecedor> retorno = null;
        try{
            Fornecedor fornecedor = fornecedorBo.findById(id);
            if ( fornecedor == null ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null);
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, fornecedor);
                return ResponseEntity.ok(retorno);
            }
        }catch (Exception e){
            logger.error("findOne",e);
            return ResponseEntity.status(500).body(
                    new ResultadoServico<>(
                            ApplicationConstants.RESULTADO_SERVICO_SERVER_ERROR, null)
            );
        }
    }
}
