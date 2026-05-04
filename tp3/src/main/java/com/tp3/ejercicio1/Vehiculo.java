package com.tp3.ejercicio1;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected double tarifaBase;

    public Vehiculo(String marca, String modelo, double tarifaBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaBase = tarifaBase;
    }

    public abstract void mostrarDetalles();

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }
}
