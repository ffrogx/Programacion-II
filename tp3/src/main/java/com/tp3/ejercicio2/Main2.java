package com.tp3.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("====== EJERCICIO 2: GESTOR DE SUSCRIPCIONES DE STREAMING ======\n");

        List<Suscripcion> suscripciones = new ArrayList<>();

        // Crear suscripciones
        suscripciones.add(new PlanBasico("user1@email.com", 101, 9.99));
        suscripciones.add(new PlanFamiliar("user2@email.com", 102, 15.99, 2, 3.50));
        suscripciones.add(new PlanPremium("user3@email.com", 103, 19.99, 8.00, true));
        suscripciones.add(new PlanFamiliar("user4@email.com", 104, 15.99, 3, 3.50));
        suscripciones.add(new PlanBasico("user5@email.com", 105, 9.99));
        suscripciones.add(new PlanPremium("user6@email.com", 106, 19.99, 8.00, true));

        // Mostrar todas las suscripciones y calcular ingresos
        System.out.println("SUSCRIPCIONES ACTIVAS:\n");
        double ingresoTotal = 0;
        
        for (Suscripcion suscripcion : suscripciones) {
            System.out.println(suscripcion);
            ingresoTotal += suscripcion.calcularCostoMensual();
        }

        System.out.println("\n====== RESUMEN FINANCIERO ======");
        System.out.println("Total de suscriptores: " + suscripciones.size());
        System.out.println("Ingreso mensual total: $" + String.format("%.2f", ingresoTotal));
        System.out.println("Ingreso promedio por suscriptor: $" + 
                          String.format("%.2f", ingresoTotal / suscripciones.size()));
    }
}
