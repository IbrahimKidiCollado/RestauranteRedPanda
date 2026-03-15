package com.redpanda.restaurante.controller;

//Importa la entidad Ramen para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Ramen;

//Importa el repositorio de Ramen para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.RamenRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RamenController {

    private final RamenRepository ramenRepository;

    RamenController(RamenRepository ramenRepository) {
        this.ramenRepository = ramenRepository;
    }


    @GetMapping("/ramen")
    public List<Ramen> obtenerRamen(){
        return ramenRepository.findAll();
    }

    
}