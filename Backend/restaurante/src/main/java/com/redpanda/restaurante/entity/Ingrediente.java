package com.redpanda.restaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
//Nombre de la tabla
@Table(name = "ingrediente")
public class Ingrediente {

    //Clave primaria
    @Id
    //Se genera automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Para que no mande el ID al devolver el JSON
    @JsonIgnore
    private Long id;

    //Campos de la tabla
    private String nombre;

    //Getters
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

}