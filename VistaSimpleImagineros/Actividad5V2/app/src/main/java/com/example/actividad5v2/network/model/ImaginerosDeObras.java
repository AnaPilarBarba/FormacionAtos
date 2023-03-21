package com.example.actividad5v2.network.model;

public class ImaginerosDeObras {

    private String id;
    private String name;
    private int edad;
    private String localidad;

    public String getName(){
        return name;
    }

    public  String getLocalidad(){
        return localidad;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEdad(){
        return edad;
    }
}
