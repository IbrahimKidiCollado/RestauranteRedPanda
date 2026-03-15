package com.redpanda.restaurante.controller;

//Importa la entidad Ramen para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Bebida;

//Importa el repositorio de Ramen para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.BebidaRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BebidaController {

    private final  BebidaRepository bebidaRepository;

    BebidaController(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    @GetMapping("/bebida")
    public List<Bebida> obtenerBebida(){
        return bebidaRepository.findAll();
    }

    
}