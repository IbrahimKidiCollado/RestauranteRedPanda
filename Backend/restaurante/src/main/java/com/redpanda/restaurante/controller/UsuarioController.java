package com.redpanda.restaurante.controller;

//Importa la entidad Usuario para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Usuario;

//Importa el repositorio de usuarios para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    UsuarioController(UsuarioRepository usuarioRepository) {
            this.usuarioRepository = usuarioRepository;
    }

    //Para iniciar Sesion nada mas entrar en la web
    //En el body se enviará un JSON con el email y la contraseña del usuario
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody Usuario datosLogin, HttpSession sesion) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(datosLogin.getEmail());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getPwd().equals(datosLogin.getPwd())) {
                sesion.setAttribute("usuario", usuario);
                //devolvemos el usuario para mostrar su nombre en la interfaz
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        
    }

    //Registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario nuevoUsuario) {
       if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()).isPresent()) {
            return ResponseEntity.status(400).build(); // Usuario ya existe
        }
        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);
        return ResponseEntity.ok(usuarioGuardado);
        
    }


    //Cierra sesion
    @PostMapping("/logout")
    public ResponseEntity<String> cerrarSesion(HttpSession sesion) {
        sesion.invalidate();
        return ResponseEntity.ok("Sesión cerrada");
    }
    
    

    

}