package com.nexxera.gestaonegocio.repository;

import com.nexxera.gestaonegocio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByLoginAndSenha(String login, String senha);

}
