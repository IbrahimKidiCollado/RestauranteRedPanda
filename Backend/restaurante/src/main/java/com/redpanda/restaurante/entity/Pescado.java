package com.redpanda.restaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
//Nombre de la tabla
@Table(name = "pescado")
public class Pescado {

    //Clave primaria PK
    @Id
    //Se genera automaticamente (AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;
    private int cantidad;
    private double precio;
    private String imagen;
    private String descripcion;

    //Relacion 1 a N
    //Varios pescados se encuentran en la carta
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
    public String getImagen(){
        return imagen;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setId(Long id) {
        this.id = id;
    }
}