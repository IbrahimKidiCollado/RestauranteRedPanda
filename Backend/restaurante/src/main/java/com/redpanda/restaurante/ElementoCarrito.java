package com.redpanda.restaurante;

public class ElementoCarrito {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria_slug;
    private String imagen;

    public ElementoCarrito(int id, String nombre, double precio, int cantidad, String categoria, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria_slug = categoria;
        this.imagen = imagen;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria_slug() {
        return categoria_slug;
    }

    public void setCategoria_slug(String categoria_slug) {
        this.categoria_slug = categoria_slug;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



    
}
