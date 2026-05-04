package com.tp3.ejercicio2;

public class PlanFamiliar extends Suscripcion {
    private int perfilesAdicionales;
    private double costoAdionalPorPerfil;

    public PlanFamiliar(String correoElectronico, int numeroCliente, double costoBase,
                        int perfilesAdicionales, double costoAdionalPorPerfil) {
        super(correoElectronico, numeroCliente, costoBase);
        this.perfilesAdicionales = perfilesAdicionales;
        this.costoAdionalPorPerfil = costoAdionalPorPerfil;
    }

    @Override
    public double calcularCostoMensual() {
        // Costo base + recargo por cada perfil adicional
        return costoBase + (perfilesAdicionales * costoAdionalPorPerfil);
    }

    @Override
    public String toString() {
        return "PlanFamiliar [email=" + correoElectronico + ", cliente=" + numeroCliente +
               ", perfiles=" + perfilesAdicionales + ", costo=" + calcularCostoMensual() + "]";
    }

    public int getPerfilesAdicionales() {
        return perfilesAdicionales;
    }
}
