package com.redpanda.restaurante.controller;

//Importa la entidad Sushi para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Sushi;

//Importa el repositorio de Sushi para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.SushiRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SushiController {

    private final SushiRepository sushiRepository;

    SushiController(SushiRepository sushiRepository) {
        this.sushiRepository = sushiRepository;
    }


    @GetMapping("/sushi")
    public List<Sushi> obtenerSushi(){
        return sushiRepository.findAll();
    }

    
}