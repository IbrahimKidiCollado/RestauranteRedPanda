package com.redpanda.restaurante.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String email;
    private String preferenciaIdioma;

    //Relacion 1 a N
    //Un usuario puede tener varios pedidos
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Pedido> pedidos;


    //Getters
    public Long getId() {
        return id;
    }
    public String getPwd() {
        return pwd;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getPreferenciaIdioma() {
        return preferenciaIdioma;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPreferenciaIdioma(String preferenciaIdioma) {
        this.preferenciaIdioma = preferenciaIdioma;
    }


}