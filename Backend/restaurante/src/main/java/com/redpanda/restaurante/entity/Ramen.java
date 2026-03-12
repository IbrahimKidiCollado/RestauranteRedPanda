package com.redpanda.restaurante.entity;

import jakarta.persistence.*;
import java.util.List;

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

}