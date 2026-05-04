package com.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("====== EJERCICIO 1: SISTEMA DE FLOTA DE TRANSPORTE ======\n");

        List<Vehiculo> flota = new ArrayList<>();

        // Crear vehículos
        flota.add(new Furgoneta("Mercedes", "Sprinter", 150.0, 2500));
        flota.add(new Furgoneta("Iveco", "Daily", 140.0, 3000));
        flota.add(new Motocicleta("Yamaha", "YZF-R1", 50.0, 998));
        flota.add(new Motocicleta("Honda", "CB500F", 45.0, 471));
        flota.add(new Furgoneta("Volvo", "FH16", 200.0, 5000));

        // Mostrar reporte detallado
        System.out.println("REPORTE DE FLOTA:\n");
        for (Vehiculo vehiculo : flota) {
            vehiculo.mostrarDetalles();
        }

        // Calcular tarifa total promedio
        double tarifaPromedio = flota.stream()
                .mapToDouble(Vehiculo::getTarifaBase)
                .average()
                .orElse(0);

        System.out.println("Tarifa promedio de la flota: $" + String.format("%.2f", tarifaPromedio));
        System.out.println("Total de vehículos: " + flota.size());
    }
}
