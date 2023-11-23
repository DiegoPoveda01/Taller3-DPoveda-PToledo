package com.example.taller3.model;

public class Entrada {
    private String tipo;
    private int precio;
    private boolean disponible;
    public Entrada(String tipo, int precio, boolean disponible) {
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "Entrada [tipo=" + tipo + ", precio=" + precio + ", disponible=" + disponible + "]";
    }
}
