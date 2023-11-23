package com.example.taller3.model;

public class Artista {
    private String nombre;
    private String genero;
    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
    public String getNombre() {
        return nombre;
    }
    public String getGenero() {
        return genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Artista [nombre=" + nombre + ", genero=" + genero + "]";
    }
}
