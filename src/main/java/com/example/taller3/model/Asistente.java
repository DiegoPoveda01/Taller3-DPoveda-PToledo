package com.example.taller3.model;

public class Asistente {
    private int numero;
    private String preferencia;
    public Asistente(int numero, String preferencia) {
        this.numero = numero;
        this.preferencia = preferencia;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getPreferencia() {
        return preferencia;
    }
    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
    @Override
    public String toString() {
        return "Asistente [numero=" + numero + ", preferencia=" + preferencia + "]";
    }
}
