package com.redpanda.restaurante.controller;

import com.redpanda.restaurante.entity.Carta;
import com.redpanda.restaurante.repository.CartaRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TestController {

    private final CartaRepository cartaRepository;

    TestController(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }


    @GetMapping("/carta")
    public List<Carta> obteneCarta(){
        return cartaRepository.findAll();
    }

    @PostMapping("/sushi")
    public String postMethodName(@RequestBody String entity) {
        return "API POST para sushi";
        //return entity;
    }

    
}