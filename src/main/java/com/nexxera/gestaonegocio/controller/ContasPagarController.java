package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.bo.ContasPagarBo;
import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.dto.ContasPagarDTO;
import com.nexxera.gestaonegocio.entity.ContasPagar;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas/pagar/")
public class ContasPagarController {

    private static Logger logger = LoggerFactory.getLogger(ContasPagarController.class);

    @Autowired
    ContasPagarBo contasPagarBo;

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<ResultadoServico<List<ContasPagar>>> listAll(){
        ResultadoServico<List<ContasPagar>> retorno = null;
        try{
            List<ContasPagar> contasPagar = contasPagarBo.findAll();
            if ( contasPagar.isEmpty() ){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null);
                return ResponseEntity.status(204).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, contasPagar);
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
    @PostMapping
    public ResponseEntity<ResultadoServico<ContasPagarDTO>> create(@RequestBody ContasPagarDTO conta){
        ResultadoServico<ContasPagarDTO> retorno = new ResultadoServico<>("Insert OK", conta );
        ContasPagar cpRetorno = null;
        try{
            cpRetorno = contasPagarBo.save(contasPagarBo.parseContasPagar(conta));
            retorno.setData(ContasPagarDTO.parseContasPagarDTO(cpRetorno));
            return ResponseEntity.ok(retorno);
        }catch (Exception e){
            logger.error("create",e);
            retorno = new ResultadoServico<>("Delete Error", ContasPagarDTO.parseContasPagarDTO(cpRetorno) );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(retorno);
        }

    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<ResultadoServico<ContasPagarDTO>> update(@RequestBody ContasPagarDTO conta){
        ResultadoServico<ContasPagarDTO> retorno = new ResultadoServico<>("Update OK", null );
        ContasPagar cpRetorno = null;
        try{
            cpRetorno = contasPagarBo.save(contasPagarBo.parseContasPagar(conta));
            retorno.setData(ContasPagarDTO.parseContasPagarDTO(cpRetorno));
            return ResponseEntity.ok(retorno);
        }catch (Exception e){
            logger.error("update",e);
            retorno = new ResultadoServico<>("Update Error", ContasPagarDTO.parseContasPagarDTO(cpRetorno) );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(retorno);
        }
    }

    @CrossOrigin
    @GetMapping(value = "{id}")
    public ResponseEntity<ResultadoServico<ContasPagarDTO>> findOne(@PathVariable(value = "id") Long id){
        ResultadoServico<ContasPagarDTO> retorno = null;
        ContasPagar cpRetorno = null;
        try{
            cpRetorno = contasPagarBo.findOne(id);
            if (cpRetorno != null) {
                retorno = new ResultadoServico<>("Find OK", null );
                retorno.setData(ContasPagarDTO.parseContasPagarDTO(cpRetorno));
                return ResponseEntity.ok(retorno);
            }else{
                retorno = new ResultadoServico<>("No Results Found", null );
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(retorno);
            }
        }catch (Exception e){
            logger.error("findOne",e);
            retorno = new ResultadoServico<>("Find Error", ContasPagarDTO.parseContasPagarDTO(cpRetorno));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(retorno);
        }
    }

    @CrossOrigin
    @DeleteMapping(value = "{id}")
    public ResponseEntity<ResultadoServico<ContasPagarDTO>> delete(@PathVariable(value = "id") Long id){
        ResultadoServico<ContasPagarDTO> retorno = null;
        ContasPagar cpRetorno = null;
        try{

            cpRetorno = contasPagarBo.findOne(id);
            contasPagarBo.delete(id);
            if (cpRetorno != null) {
                retorno = new ResultadoServico<>("Delete OK", ContasPagarDTO.parseContasPagarDTO(cpRetorno));
                return ResponseEntity.ok(retorno);
            }else{
                retorno = new ResultadoServico<>("No Results Found for Delete", null);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(retorno);
            }
        }catch (Exception e){
            logger.error("delete",e);
            retorno = new ResultadoServico<>("Delete Error", ContasPagarDTO.parseContasPagarDTO(cpRetorno));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(retorno);
        }
    }
}
