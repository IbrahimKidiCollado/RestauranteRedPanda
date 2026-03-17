package com.redpanda.restaurante.controller;

//Importa la entidad Carta para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Usuario;

//Importa el repositorio de Carta para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.UsuarioRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public List<Usuario> obteneUsuario(@RequestBody Usuario loginData) {
        return usuarioRepository.findBy(null, null);
    }

    
}