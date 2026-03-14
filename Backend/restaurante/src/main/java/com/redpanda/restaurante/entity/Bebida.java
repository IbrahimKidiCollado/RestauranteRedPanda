package com.redpanda.restaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
//Nombre de la tabla
@Table(name = "bebida")
public class Bebida {

    //Clave primaria PK
    @Id
    //Se genera automaticamente (AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;
    private int cantidad;
    private double precio;

    //Relacion 1 a N
    //Varias bebidas se encuentran en la carta
    //Clave foranea FK
    @ManyToOne
    @JoinColumn(name = "id_carta")
    @JsonIgnore
    private Carta carta;

    //Getters
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
}