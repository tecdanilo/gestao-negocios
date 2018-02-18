package com.nexxera.gestaonegocio.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @AllArgsConstructor
public class ResultadoServico<T> implements Serializable {
    private String msg;
    private T data;
    private List<String> errors;
}
