package com.redpanda.restaurante.repository;

//Importa la interfaz que permite que Spring genere automáticamente consultas SQL
import org.springframework.data.jpa.repository.JpaRepository;
//Importa la entidad Carta
import com.redpanda.restaurante.entity.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long> {

}
