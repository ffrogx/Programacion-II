package com.tp3.ejercicio1;

public class Motocicleta extends Vehiculo {
    private int cilindrada; // en cc

    public Motocicleta(String marca, String modelo, double tarifaBase, int cilindrada) {
        super(marca, modelo, tarifaBase);
        this.cilindrada = cilindrada;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== MOTOCICLETA ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tarifa Base: $" + tarifaBase);
        System.out.println("Cilindrada: " + cilindrada + " cc");
        System.out.println();
    }

    public int getCilindrada() {
        return cilindrada;
    }
}
