package com.tp3.ejercicio2;

public class PlanPremium extends Suscripcion {
    private double cargoExtra4K;
    private boolean descargas;

    public PlanPremium(String correoElectronico, int numeroCliente, double costoBase,
                       double cargoExtra4K, boolean descargas) {
        super(correoElectronico, numeroCliente, costoBase);
        this.cargoExtra4K = cargoExtra4K;
        this.descargas = descargas;
    }

    @Override
    public double calcularCostoMensual() {
        // Costo base + cargo fijo extra por 4K y descargas
        return costoBase + cargoExtra4K;
    }

    @Override
    public String toString() {
        return "PlanPremium [email=" + correoElectronico + ", cliente=" + numeroCliente +
               ", 4K=" + descargas + ", costo=" + calcularCostoMensual() + "]";
    }

    public double getCargoExtra4K() {
        return cargoExtra4K;
    }

    public boolean tieneDescargas() {
        return descargas;
    }
}
