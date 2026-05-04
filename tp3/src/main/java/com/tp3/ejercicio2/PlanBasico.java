package com.tp3.ejercicio2;

public class PlanBasico extends Suscripcion {

    public PlanBasico(String correoElectronico, int numeroCliente, double costoBase) {
        super(correoElectronico, numeroCliente, costoBase);
    }

    @Override
    public double calcularCostoMensual() {
        // Plan Básico solo cobra el costo base
        return costoBase;
    }

    @Override
    public String toString() {
        return "PlanBasico [email=" + correoElectronico + ", cliente=" + numeroCliente + 
               ", costo=" + calcularCostoMensual() + "]";
    }
}
