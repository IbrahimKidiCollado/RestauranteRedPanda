package com.redpanda.restaurante.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//Nombre de la tabla
@Table(name = "ramen")
public class Ramen {

    //Clave primaria PK
    @Id
    //Se genera automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;
    private int cantidad;
    private double precio;

    //Relacion 1 a N 
    //Varios ramenes pueden estar en una carta
    @ManyToOne
    @JoinColumn(name = "id_carta")
    @JsonIgnore
    private Carta carta;
    
    //Relacion N a M 
    //En un ramen hay varios ingredientes y un ingrediente esta en varios ramenes
    @ManyToMany
    //Creamos la tabla intermedia
    @JoinTable(
        name = "ramen_ingrediente",
        //Primera parte de la clave
        joinColumns = @JoinColumn(name = "id_ramen"),
        //Segunda parte de la clave
        inverseJoinColumns = @JoinColumn(name = "id_ingrediente")
    )
    private List<Ingrediente> ingredientes;

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