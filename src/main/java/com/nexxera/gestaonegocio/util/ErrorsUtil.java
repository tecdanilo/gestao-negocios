package com.nexxera.gestaonegocio.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária para minupulação de lista de descrições de erros.
 */
public class ErrorsUtil {

    private ErrorsUtil(){
    }

    public static List<String> buildErrorsListWithPreData(String error){
        List<String> retorno = new ArrayList<>();
        retorno.add(error);
        return retorno;
    }


}
