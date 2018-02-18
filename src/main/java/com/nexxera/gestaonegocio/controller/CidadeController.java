package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.entity.Cidade;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import com.nexxera.gestaonegocio.repository.CidadeRepository;
import com.nexxera.gestaonegocio.util.ErrorsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cidade/")
public class CidadeController {

    private static Logger logger = LoggerFactory.getLogger(CidadeController.class);

    @Autowired
    CidadeRepository cidadeRepository;

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<ResultadoServico<List<Cidade>>> listAll(){
        ResultadoServico<List<Cidade>> retorno = null;
        try{
            List<Cidade> cidades = cidadeRepository.findAll();
            if ( cidades.isEmpty() ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null, ErrorsUtil.buildErrorsListWithPreData("Nenhum Fornecedor Cadastrado"));
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, cidades, null);
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
    public ResponseEntity<ResultadoServico<Cidade>> findOne(@PathVariable(value = "id") Long id){
        ResultadoServico<Cidade> retorno = null;
        try{
            Cidade cidade = cidadeRepository.findOne(id);
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
