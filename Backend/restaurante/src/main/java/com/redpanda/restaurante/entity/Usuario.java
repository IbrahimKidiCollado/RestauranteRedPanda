package com.redpanda.restaurante.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
//Especificar el nombre de la tabla
@Table(name = "usuarios")
public class Usuario {

    //Definimos la clave primaria
    @Id
    //Para que se genere automaticamente(AUTO_INCREMENT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campos de la tabla
    private String pwd;
    private String nombre;
    private String preferenciaIdioma;

    //Relacion 1 a N
    //Un usuario puede tener varios pedidos
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    //Relacion 1 a 1
    //Un usuario tiene un carrito
    //Clave foranea FK
    @OneToOne(mappedBy = "usuario")
    private List<Carrito> carrito;

}