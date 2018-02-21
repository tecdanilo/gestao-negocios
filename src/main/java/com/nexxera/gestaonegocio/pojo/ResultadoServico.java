package com.nexxera.gestaonegocio.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe destianda a padronizar os retornos de dados das camadas de API.
 * @param <T> Objeto genérico, o qual será retornado pelas APIs
 */
@Getter @Setter @AllArgsConstructor
public class ResultadoServico<T> {
    private String msg;
    private T data;
}
