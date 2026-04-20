package com.tp2.tp2;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso de Calculadora
        Calculadora calc = new Calculadora();
        System.out.println("Suma: " + calc.sumar(5, 3));
        System.out.println("Resta: " + calc.restar(5, 3));

        // Ejemplo de Reloj
        Reloj reloj = new Reloj(10, 30, 45);
        System.out.println("Tiempo inicial: " + reloj.getTiempo());
        reloj.avanzarSegundo();
        System.out.println("Despues de un segundo: " + reloj.getTiempo());

        // Ejemplo de CuentaBancaria
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        System.out.println("Saldo despues de deposito: " + cuenta.getSaldo());
        cuenta.retirar(200);
        System.out.println("Saldo despues de retiro: " + cuenta.getSaldo());

        // Ejemplo de Libro
        Libro libro = new Libro("El Quijote", "Cervantes", 1000);
        System.out.println("Libro: " + libro.getTitulo() + " por " + libro.getAutor());

        // Ejemplo de Empleado
        Empleado empleado = new Empleado("Juan", "Desarrollador", 50000);
        System.out.println("Empleado: " + empleado.getNombre() + ", Puesto: " + empleado.getPuesto() + ", Salario: " + empleado.getSalario());
    }
}