package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Usuario;

import java.util.List;

public interface UsuarioBo {

    Usuario saveOrUpdate(Usuario usuario);

    boolean deleteById(Long id);

    List<Usuario> findAll();

    Usuario findByLoginAndSenha(String login, String senha);

    Usuario findOne(Long id);
}
