package com.redpanda.restaurante.controller;

//Importa la entidad Entrante para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Entrante;

//Importa el repositorio de Entrante para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.EntranteRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EntranteController {

    private final EntranteRepository entranteRepository;

    EntranteController(EntranteRepository entranteRepository) {
        this.entranteRepository = entranteRepository;
    }


    @GetMapping("/entrante")
    public List<Entrante> obtenerEntrante(){
        return entranteRepository.findAll();
    }

    //Para crear un nuevo entrante y añadirlo a la carta
    @PostMapping("/entrante/create")
    public Entrante addEntrante(@RequestBody Entrante nuevoEntrante) {
        // El repositorio guarda el entrante y nos devuelve el entrante guardado con su ID generado.
        return entranteRepository.save(nuevoEntrante);
    }

    //Para borra un entrante de la carta
    @DeleteMapping("/entrante/delete{id}")
    public String eliminarEntrante(@PathVariable Long id){
        //Comprobamos si existe un entrante con dicho id
        if (entranteRepository.existsById(id)) {
            //Si existe lo eliminamos
            entranteRepository.deleteById(id);
            return "Entrante eliminado correctamente: " + id; 
        }else{
            //Si no existe devolvemos un mensaje de error
            return "Error: no existe o no se ha podido eliminar el entrante con id: " + id;
        }
    }

    
}