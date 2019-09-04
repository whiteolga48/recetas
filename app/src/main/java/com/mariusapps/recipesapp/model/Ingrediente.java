package com.mariusapps.recipesapp.model;

public class Ingrediente {

    private Long id;
    private String nombre;
    private String medida;

    public Ingrediente(Long id, String nombre, String medida) {
        this.id = id;
        this.nombre = nombre;
        this.medida = medida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", medida='" + medida + '\'' +
                '}';
    }
}
