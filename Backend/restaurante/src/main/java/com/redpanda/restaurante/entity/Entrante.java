package com.redpanda.restaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
//Nombre de la tabla
@Table(name = "entrante")
public class Entrante {

    //Clave primaria
    @Id
    //Se genera automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;
    private String descripcion;
    private double precio;

    //Relacion 1 a N
    //Varios entrantes estan en la carta
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
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }


}