package com.mariusapps.recipesapp.model;

import java.util.List;

public class Receta {

    private Long id;
    private String nombre;
    private List<Ingrediente> ingredientes;
    private String foto;
    private CategoriaReceta categoriaReceta;
    private int tiempoDeCoccion;
    private int tiempoDePreparacion;
    private Temperatura temperatura;
    private Dificultad dificultad;
    private double coste;
    private List<String> pasos;

    public Receta(Long id, String nombre, List<Ingrediente> ingredientes, String foto, CategoriaReceta categoriaReceta, int tiempoDeCoccion, int tiempoDePreparacion, Temperatura temperatura, Dificultad dificultad, double coste, List<String> pasos) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.foto = foto;
        this.categoriaReceta = categoriaReceta;
        this.tiempoDeCoccion = tiempoDeCoccion;
        this.tiempoDePreparacion = tiempoDePreparacion;
        this.temperatura = temperatura;
        this.dificultad = dificultad;
        this.coste = coste;
        this.pasos = pasos;
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

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public CategoriaReceta getCategoriaReceta() {
        return categoriaReceta;
    }

    public void setCategoriaReceta(CategoriaReceta categoriaReceta) {
        this.categoriaReceta = categoriaReceta;
    }

    public int getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(int tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public List<String> getPasos() {
        return pasos;
    }

    public void setPasos(List<String> pasos) {
        this.pasos = pasos;
    }


    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                ", foto='" + foto + '\'' +
                ", categoriaReceta=" + categoriaReceta +
                ", tiempoDeCoccion=" + tiempoDeCoccion +
                ", tiempoDePreparacion=" + tiempoDePreparacion +
                ", temperatura=" + temperatura +
                ", dificultad=" + dificultad +
                ", coste=" + coste +
                ", pasos=" + pasos +
                '}';
    }
}

