package com.redpanda.restaurante.controller;

//Importa la entidad Carrito para que el controlador sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Carrito;
import com.redpanda.restaurante.entity.Carta;
//Importa el repositorio de Carrito para que el controlador pueda acceder a los datos de la tabla correspondiente
import com.redpanda.restaurante.repository.CarritoRepository;
import com.redpanda.restaurante.repository.CartaRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CarritoController {

    private final CarritoRepository carritoRepository;
    private final CartaRepository cartaRepository;

    CarritoController(CarritoRepository carritoRepository, CartaRepository cartaRepository) {
        this.carritoRepository = carritoRepository;
        this.cartaRepository = cartaRepository;
    }

    @PostMapping("/carrito/add/{id}")
    public List<Carrito> addProducto( @PathVariable Long id) {
        Carta producto = cartaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        
        return carritoRepository.addProducto(producto);
    }

    
}