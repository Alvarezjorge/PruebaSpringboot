package com.prueba.Pruebae.Controllers;

import com.prueba.Pruebae.dao.UsuarioDao;
import com.prueba.Pruebae.models.Usuario;
import com.prueba.Pruebae.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value= "api/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
       if (usuarioLogueado != null) {
           String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
           return tokenJwt;
        }
        return "FAIL";
    }
}
