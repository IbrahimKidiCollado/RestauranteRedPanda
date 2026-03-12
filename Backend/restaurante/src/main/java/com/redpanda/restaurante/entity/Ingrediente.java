package com.redpanda.restaurante.entity;

import jakarta.persistence.*;

@Entity
//Nombre de la tabla
@Table(name = "ingrediente")
public class Ingrediente {

    //Clave primaria
    @Id
    //Se genera automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;

}