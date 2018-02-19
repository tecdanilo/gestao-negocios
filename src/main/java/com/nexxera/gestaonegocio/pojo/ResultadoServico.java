package com.nexxera.gestaonegocio.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ResultadoServico<T> {
    private String msg;
    private T data;
}
