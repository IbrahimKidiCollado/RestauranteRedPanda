package com.redpanda.restaurante.repository;

import java.util.List;

//Importa la interfaz que permite que Spring genere automáticamente consultas SQL
import org.springframework.data.jpa.repository.JpaRepository;
//Importa la entidad Carrito para que el repositorio sepa a qué tabla de la base de datos se refiere
import com.redpanda.restaurante.entity.Carrito;
import com.redpanda.restaurante.entity.Carta;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    List<Carrito> addProducto(Carta producto);


}
