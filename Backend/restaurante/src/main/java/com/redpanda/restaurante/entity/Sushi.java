package com.redpanda.restaurante.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
//Nombre de la tabla
@Table(name = "sushi")
public class Sushi {

    //Calve primaria PK
    @Id
    //Se genera automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;
    private String descripcion;
    private int numeroPiezas;
    private double precio;

    //Relacion 1 a N 
    //Varios shushis pueden estar en una carta
    @ManyToOne
    @JoinColumn(name = "id_carta")
    private Carta carta;

    //Relacion N a M 
    //Un sushi puede tener varios ingredientes y un ingrediente pueden estar en varios sushis
    @ManyToMany
    //Definimos la tabla intermedia
    @JoinTable(
        name = "sushi_ingrediente",
        //Primera parte de la clave
        joinColumns = @JoinColumn(name = "id_sushi"),
        //Segunda parte de la  clave
        inverseJoinColumns = @JoinColumn(name = "id_ingrediente")
    )
    private List<Ingrediente> ingredientes;

}