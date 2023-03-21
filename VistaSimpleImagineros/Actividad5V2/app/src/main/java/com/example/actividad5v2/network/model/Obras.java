package com.example.actividad5v2.network.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

public class Obras {

    private double precio;
    private String titulo;
    private String img;
    private String estado;
    private String fecha;
    private String estilo;
    private ImaginerosDeObras imaginero;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    public Obras() {
    }

    public ImaginerosDeObras getImagineroDeObras() {
        return imaginero;
    }

    public void setImagineroDeObras(ImaginerosDeObras imagineroDeObras) {
        this.imaginero = imagineroDeObras;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
