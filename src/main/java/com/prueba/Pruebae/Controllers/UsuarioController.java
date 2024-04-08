package com.prueba.Pruebae.Controllers;


import com.prueba.Pruebae.dao.UsuarioDao;
import com.prueba.Pruebae.models.Usuario;


import com.prueba.Pruebae.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;




@RestController
public class UsuarioController{

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(value= "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Mendez");
        usuario.setEmail("LM@gmail.com");
        usuario.setTelefono("86196978");
        usuario.setPassword("");
        return usuario;
    }

    @GetMapping(value= "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
             if(!validarToken(token)) {
                 return null;
             }

       return usuarioDao.getUsuarios();
    }
    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @PostMapping(value= "api/usuarios")
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);

    }

    @DeleteMapping(value= "api/usuarios/{id}")
    public void eliminar(@RequestHeader(value="Authorization") String token,
                           @PathVariable long id) {
            if (validarToken(token)) { return; }
        usuarioDao.eliminar(id);
       
    }
}



