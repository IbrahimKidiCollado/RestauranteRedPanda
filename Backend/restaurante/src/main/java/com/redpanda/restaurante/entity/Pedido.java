package com.redpanda.restaurante.entity;

import jakarta.persistence.*;

@Entity
//Nombre de la tabla
@Table(name = "pedido")
public class Pedido {

    //Clave primaria
    @Id
    //Se genera automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    //Relacion 1 a N 
    //Varios pedidos pertenecen a UN usuario
    //Es la clave foranea FK
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}