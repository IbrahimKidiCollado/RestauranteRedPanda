package com.redpanda.restaurante.entity;

import jakarta.persistence.*;

@Entity
//Especificamos el nombre de la Tabla
@Table(name = "carrito")
public class Carrito {

    //La clave Primario PK
    @Id
    //Se genera automaticamente (AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos que tiene nuestra tabla
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    //Relacion 1 a 1
    //Un usuario puede tener un carrito
    //Es clave foranea FK
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}