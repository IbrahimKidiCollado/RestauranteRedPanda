package com.redpanda.restaurante.controller;

//Importa la entidad Carta para que el controlador sepa a qué tabla de la base de datos se refiere
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redpanda.restaurante.entity.Carta;
import com.redpanda.restaurante.repository.CartaRepository;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CartaController {

    private final CartaRepository cartaRepository;

    CartaController(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }

    @GetMapping("/carta")
    public List<Carta> obteneCarta(){
        return cartaRepository.findAll();
    }

    
}