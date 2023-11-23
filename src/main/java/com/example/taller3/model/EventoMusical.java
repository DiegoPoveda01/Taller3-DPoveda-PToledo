package com.example.taller3.model;

import java.util.List;

public class EventoMusical {
    private String nombre;
    private String fecha;
    private String lugar;
    private List<Artista> artistas;
    public EventoMusical(String nombre, String fecha, String lugar, List<Artista> artistas) {
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
    public List<Artista> getArtistas() {
        return artistas;
    }
    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
    @Override
    public String toString() {
        return "EventoMusical [artistas=" + artistas + ", fecha=" + fecha + ", lugar=" + lugar + ", nombre=" + nombre
                + "]";
    }
}
