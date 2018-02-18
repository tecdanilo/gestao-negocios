package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.bo.EstadoBo;
import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.entity.Estado;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import com.nexxera.gestaonegocio.util.ErrorsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/estado/")
public class EstadoController {

    private static Logger logger = LoggerFactory.getLogger(EstadoController.class);

    @Autowired
    EstadoBo estadoBo;

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<ResultadoServico<List<Estado>>> listAll(){
        ResultadoServico<List<Estado>> retorno = null;
        try{
            List<Estado> estados = estadoBo.findAll();
            if ( estados.isEmpty() ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null, ErrorsUtil.buildErrorsListWithPreData("Nenhum Fornecedor Cadastrado"));
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, estados, null);
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

    @CrossOrigin
    @GetMapping(value = "{id}")
    public ResponseEntity<ResultadoServico<Estado>> findOne(@PathVariable(value = "id") Long id){
        ResultadoServico<Estado> retorno = null;
        try{
            Estado cidade = estadoBo.findOne(id);
            if ( cidade == null ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null, ErrorsUtil.buildErrorsListWithPreData("Nenhum Fornecedor Cadastrado"));
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, cidade, null);
                return ResponseEntity.ok(retorno);
            }
        }catch (Exception e){
            logger.error("findOne",e);
            return ResponseEntity.status(500).body(
                    new ResultadoServico<>(
                            ApplicationConstants.RESULTADO_SERVICO_SERVER_ERROR, null,  ErrorsUtil.buildErrorsListWithPreData("Erro no processamento do servidor, se o problema persistir, contacte o administrador de sistemas")
                    )
            );
        }
    }


}
