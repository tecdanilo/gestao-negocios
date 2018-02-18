package com.nexxera.gestaonegocio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
public class UsuarioLoginDTO implements Serializable {
    private String login;
    private String senha;
    private String sessionId;
}
