package com.tp4.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("Lucia Martinez", "DNI 45.123.678");
        paciente.getExpediente().agregarEntrada(new EntradaMedica(LocalDate.now().minusDays(10), "Diagnostico", "Hipertension leve"));
        paciente.getExpediente().agregarEntrada(new EntradaMedica(LocalDate.now().minusDays(5), "Receta", "Medicamento antihipertensivo"));

        Medico medico = new Medico("Dr. Gomez", "Cardiologia");
        Consulta consulta = new Consulta(paciente, medico, LocalDate.now(), "Control de presion arterial");

        System.out.println("=== Consulta medica ===");
        System.out.println(consulta);
        System.out.println("\n=== Evolucion historica del paciente ===");
        System.out.println(paciente.generarReporteEvolucion());

        paciente.darDeBaja();
        System.out.println("\n=== Paciente dado de baja ===");
        System.out.println(paciente);
    }

    static class Paciente {
        private final String nombre;
        private final String documento;
        private ExpedienteClinico expediente;
        private boolean activo = true;

        public Paciente(String nombre, String documento) {
            this.nombre = nombre;
            this.documento = documento;
            this.expediente = new ExpedienteClinico(this);
        }

        public ExpedienteClinico getExpediente() {
            return expediente;
        }

        public String generarReporteEvolucion() {
            if (!activo || expediente == null) {
                return "Paciente dado de baja. No hay expediente disponible.";
            }
            return expediente.generarResumen();
        }

        public void darDeBaja() {
            activo = false;
            if (expediente != null) {
                expediente.eliminarContenido();
                expediente = null;
            }
        }

        @Override
        public String toString() {
            return String.format("Paciente: %s (%s) - activo: %s", nombre, documento, activo);
        }
    }

    static class ExpedienteClinico {
        private final Paciente paciente;
        private final List<EntradaMedica> entradas = new ArrayList<>();

        public ExpedienteClinico(Paciente paciente) {
            this.paciente = paciente;
        }

        public void agregarEntrada(EntradaMedica entrada) {
            entradas.add(entrada);
        }

        public String generarResumen() {
            StringBuilder builder = new StringBuilder();
            builder.append("Expediente de ").append(paciente.nombre).append("\n");
            for (EntradaMedica entrada : entradas) {
                builder.append("  - ").append(entrada).append("\n");
            }
            return builder.toString();
        }

        public void eliminarContenido() {
            entradas.clear();
        }
    }

    static class EntradaMedica {
        private final LocalDate fecha;
        private final String tipo;
        private final String descripcion;

        public EntradaMedica(LocalDate fecha, String tipo, String descripcion) {
            this.fecha = fecha;
            this.tipo = tipo;
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return String.format("[%s] %s: %s", fecha, tipo, descripcion);
        }
    }

    static class Medico {
        private final String nombre;
        private final String especialidad;

        public Medico(String nombre, String especialidad) {
            this.nombre = nombre;
            this.especialidad = especialidad;
        }

        @Override
        public String toString() {
            return String.format("%s (%s)", nombre, especialidad);
        }
    }

    static class Consulta {
        private final Paciente paciente;
        private final Medico medico;
        private final LocalDate fecha;
        private final String motivo;

        public Consulta(Paciente paciente, Medico medico, LocalDate fecha, String motivo) {
            this.paciente = paciente;
            this.medico = medico;
            this.fecha = fecha;
            this.motivo = motivo;
        }

        @Override
        public String toString() {
            return String.format("Consulta: %s - medico: %s - fecha: %s - motivo: %s", paciente.nombre, medico, fecha, motivo);
        }
    }
}
