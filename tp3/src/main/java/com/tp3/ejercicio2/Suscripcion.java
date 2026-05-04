package com.tp3.ejercicio2;

public abstract class Suscripcion {
    protected String correoElectronico;
    protected int numeroCliente;
    protected double costoBase;

    public Suscripcion(String correoElectronico, int numeroCliente, double costoBase) {
        this.correoElectronico = correoElectronico;
        this.numeroCliente = numeroCliente;
        this.costoBase = costoBase;
    }

    public abstract double calcularCostoMensual();

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public double getCostoBase() {
        return costoBase;
    }
}
