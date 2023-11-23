package com.example.taller3.model;

import java.util.List;

public class EventoMusical {
    private String nombre;
    private String fecha;
    private String lugar;
    private String artistas;
    public EventoMusical(String nombre, String fecha, String lugar, String artistas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.artistas = artistas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getArtistas() {
        return artistas;
    }
    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }
    @Override
    public String toString() {
        return "EventoMusical [artistas=" + artistas + ", fecha=" + fecha + ", lugar=" + lugar + ", nombre=" + nombre
                + "]";
    }
}
