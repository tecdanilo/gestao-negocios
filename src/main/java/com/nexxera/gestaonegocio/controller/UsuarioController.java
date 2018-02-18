package com.nexxera.gestaonegocio.controller;

import com.nexxera.gestaonegocio.bo.UsuarioBo;
import com.nexxera.gestaonegocio.constants.ApplicationConstants;
import com.nexxera.gestaonegocio.dto.UsuarioLoginDTO;
import com.nexxera.gestaonegocio.entity.Usuario;
import com.nexxera.gestaonegocio.pojo.ResultadoServico;
import com.nexxera.gestaonegocio.util.ErrorsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioBo usuarioBo;

    @CrossOrigin
    @PostMapping(value = "login")
    public ResponseEntity<ResultadoServico<Usuario>> login(@RequestBody(required = true) UsuarioLoginDTO usuarioLoginDTO){
        ResultadoServico<Usuario> retorno;

        try {
            Usuario user = usuarioBo.findByLoginAndSenha(usuarioLoginDTO.getLogin(), usuarioLoginDTO.getSenha());
            if (user == null){
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_NO_DATA_FOUND, null, ErrorsUtil.buildErrorsListWithPreData("Usuário ou senha inválidos."));
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(retorno);
            }else{
                retorno = new ResultadoServico<>(ApplicationConstants.RESULTADO_SERVICO_OK, user, null);
                return ResponseEntity.ok(retorno);
            }
        } catch (Exception e) {
            logger.error("login",e);

            return ResponseEntity.status(500).body(
                    new ResultadoServico<>(
                                ApplicationConstants.RESULTADO_SERVICO_SERVER_ERROR, null,  ErrorsUtil.buildErrorsListWithPreData("Erro no processamento do servidor, se o problema persistir, contacte o administrador de sistemas")
                    )
            );
        }

    }
}
