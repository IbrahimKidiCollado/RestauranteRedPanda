package com.redpanda.restaurante.controller;

//Importa la entidad Ramen para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Ramen;

//Importa el repositorio de Ramen para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.RamenRepository;

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
public class RamenController {

    private final RamenRepository ramenRepository;

    RamenController(RamenRepository ramenRepository) {
        this.ramenRepository = ramenRepository;
    }


    @GetMapping("/ramen")
    public List<Ramen> obtenerRamen(){
        return ramenRepository.findAll();
    }

    //Para crear un nuevo ramen y añadirlo a la carta
    @PostMapping("/ramen/create")
    public Ramen addRamen(@RequestBody Ramen nuevoRamen) {
        // El repositorio guarda el ramen y nos devuelve el ramen guardado con su ID generado.
        return ramenRepository.save(nuevoRamen);
    }

    //Para borra un ramen de la carta
    @DeleteMapping("/ramen/delete{id}")
    public String eliminarRamen(@PathVariable Long id){
        //Comprobamos si existe un ramen con dicho id
        if (ramenRepository.existsById(id)) {
            //Si existe lo eliminamos
            ramenRepository.deleteById(id);
            return "Ramen eliminado correctamente: " + id; 
        }else{
            //Si no existe devolvemos un mensaje de error
            return "Error: no existe o no se ha podido eliminar el ramen con id: " + id;
        }
    }
    
}