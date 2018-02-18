package com.nexxera.gestaonegocio.bo;

import com.nexxera.gestaonegocio.entity.Usuario;
import com.nexxera.gestaonegocio.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioBoImpl implements UsuarioBo {

    private static Logger logger = LoggerFactory.getLogger(UsuarioBoImpl.class);

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Usuario saveOrUpdate(Usuario usuario){
        return  usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteById(Long id){
        try {
            usuarioRepository.delete(id);
            return true;
        }catch (Exception e){
            logger.error("contexto: deleteById",e);
            return false;
        }
    }

    @Override
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    @Override
    public Usuario findOne(Long id){
        return usuarioRepository.findOne(id);
    }
}
