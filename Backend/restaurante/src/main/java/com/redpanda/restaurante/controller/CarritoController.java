package com.redpanda.restaurante.controller;

import com.redpanda.restaurante.ElementoCarrito;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class CarritoController {
    private List<ElementoCarrito> carrito = new ArrayList<>();

    //Devuelve el contenido del carrito
    @GetMapping("/carrito")
    public List<ElementoCarrito> verCarrito() {
        return carrito;
    }

    //Agrega un elemento al carrito
    @PostMapping("/carrito/agregar")
    public String agregarAlCarrito(@RequestBody ElementoCarrito elemento) {
        boolean encontrado = false;
        for(ElementoCarrito plato : carrito){
            if (plato.getId() == elemento.getId()) {
                if (plato.getCategoria_slug().equals(elemento.getCategoria_slug())) {
                    plato.setCantidad(plato.getCantidad() + 1);
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            elemento.setCantidad(1);
            carrito.add(elemento);
            
        }
        return "Elemento agregado al carrito: " + elemento.getNombre();
    }

    //Eliminar un elemento del carrito
    @DeleteMapping("/carrito/eliminar/{id}")
    public String eliminarDelCarrito(@PathVariable int id, @RequestBody Map<String, String> body) {
        String categoria = body.get("categoria_slug");
        for(ElementoCarrito plato : carrito){
            if (plato.getId() == id) {
                if (plato.getCategoria_slug().equals(categoria)) {
                    carrito.remove(plato);
                    break;
                    
                }
            }
        }
        return "Elemento eliminado del carrito ";
    }

    //Suma cantidad de un elemento específico en el carrito
    @PutMapping("/carrito/sumar/{id}")
    public List<ElementoCarrito> sumarCantidad(@PathVariable int id, @RequestBody Map<String, String> body) {
        String categoria = body.get("categoria_slug");
        for (ElementoCarrito plato : carrito) {
            if (plato.getId() == id && plato.getCategoria_slug().equals(categoria) ) {
                plato.setCantidad(plato.getCantidad() + 1);
                break;
            }
        }
        return carrito;
    }

    //Resta cantidad de un elemento específico en el carrito
    @PutMapping("/carrito/restar/{id}")
    public List<ElementoCarrito> restarCantidad(@PathVariable int id, @RequestBody Map<String, String> body) {
        String categoria = body.get("categoria_slug");
        for (ElementoCarrito plato : carrito) {
            if (plato.getId() == id && plato.getCategoria_slug().equals(categoria)) {
                if (plato.getCantidad() > 1) {
                    plato.setCantidad(plato.getCantidad() - 1);
                }else{
                    carrito.remove(plato);
                }
                break;
            }
        }
        return carrito;
    }

    //Vacía el carrito
    @DeleteMapping("/carrito/vaciar")
    public String vaciarCarrito() {
        carrito.clear();
        return "Carrito vaciado.";
    }
}