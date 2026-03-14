package com.redpanda.restaurante.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
//Nombre de la tabla
@Table(name = "carta")
public class Carta {

    //Clave primaria PK
    @Id
    //Se autogenera solo (AUTO_GENERATED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relacion 1 a N
    //Una carta puede tener muchos sushis
    //Clave foranea FK
    @OneToMany(mappedBy = "carta")
    private List<Sushi> sushi;

    //Relacion 1 a N
    //Una carta puede tener muchos ramenes
    //Clave foranea FK
    @OneToMany(mappedBy = "carta")
    private List<Ramen> ramen;

    //Relacion 1 a N
    //Una carta puede tener muchos entrantes
    //Clave foranea FK
    @OneToMany(mappedBy = "carta")
    private List<Entrante> entrantes;

    //Relacion 1 a N
    //Una carta puede tener muchas bebidas
    //Clave foranea FK
    @OneToMany(mappedBy = "carta")
    private List<Bebida> bebidas;

    public Long getId() {
        return id;
    }

    public List<Sushi> getSushi() {
        return sushi;
    }

    public List<Ramen> getRamen() {
        return ramen;
    }

    public List<Entrante> getEntrantes() {
        return entrantes;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

}