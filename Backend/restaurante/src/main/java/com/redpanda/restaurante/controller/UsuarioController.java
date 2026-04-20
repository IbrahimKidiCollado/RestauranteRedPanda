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
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UsuarioController {

    //private final UsuarioRepository usuarioRepository;

   // UsuarioController(UsuarioRepository usuarioRepository) {
    //    this.usuarioRepository = usuarioRepository;
    //}

    //Para iniciar Sesion nada mas entrar en la web
    @GetMapping("/login")
    public String iniciarSesion(HttpSession sesion) {
        if (sesion.isNew()) {
            sesion.setAttribute("inicio", System.currentTimeMillis());
            return "Nueva sesion iniciada";
        }
        return "Ya existente";
    }

    //Cierra sesion
    @PostMapping("/logout")
    public String cerrarSesion(HttpSession sesion) {
        sesion.invalidate();
        return "Sesion Cerrada";
    }
    
    

    

}