package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.entity.Filial;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import com.nexxera.gestaonegocio.repository.FilialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/filial/")
public class FilialController {

    private static Logger logger = LoggerFactory.getLogger(FilialController.class);

    @Autowired
    FilialRepository filialRepository;

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<ResultadoServico<List<Filial>>> listAll(){
        ResultadoServico<List<Filial>> retorno = null;
        try{
            List<Filial> filiais = filialRepository.findAll();
            if ( filiais.isEmpty() ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null);
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, filiais);
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
    public ResponseEntity<ResultadoServico<Filial>> findOne(@PathVariable(value = "id") Long id){
        ResultadoServico<Filial> retorno = null;
        try{
            Filial filial = filialRepository.findOne(id);
            if ( filial == null ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null);
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, filial);
                return ResponseEntity.ok(retorno);
            }
        }catch (Exception e){
            logger.error("findOne",e);
            return ResponseEntity.status(500).body(
                    new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_SERVER_ERROR, null)
            );
        }
    }
}
