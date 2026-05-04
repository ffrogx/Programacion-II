package com.tp3.ejercicio1;

public class Furgoneta extends Vehiculo {
    private double capacidadCarga; // en kilogramos

    public Furgoneta(String marca, String modelo, double tarifaBase, double capacidadCarga) {
        super(marca, modelo, tarifaBase);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== FURGONETA ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tarifa Base: $" + tarifaBase);
        System.out.println("Capacidad de Carga: " + capacidadCarga + " kg");
        System.out.println();
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }
}
