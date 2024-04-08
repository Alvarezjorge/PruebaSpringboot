package com.prueba.Pruebae.dao;

import com.prueba.Pruebae.models.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioDao {

  

    
    List<Usuario> getUsuarios();


    void eliminar(long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
