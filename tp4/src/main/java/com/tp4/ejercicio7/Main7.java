package com.tp4.ejercicio7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {
        Facultad facultad = new Facultad("Ingenieria Informatica");
        Carrera carrera1 = facultad.agregarCarrera("Ingenieria en Sistemas");
        Carrera carrera2 = facultad.agregarCarrera("Licenciatura en Ciencias de la Computacion");

        Materia prog = new Materia("Programacion II", 6);
        Materia datos = new Materia("Estructuras de Datos", 8);
        Materia bases = new Materia("Bases de Datos", 6);

        carrera1.agregarMateria(prog);
        carrera1.agregarMateria(datos);
        carrera2.agregarMateria(bases);
        carrera2.agregarMateria(datos);

        carrera1.setPlanEstudios(new PlanEstudios("Plan 2024", List.of(prog, datos)));
        carrera2.setPlanEstudios(new PlanEstudios("Plan 2025", List.of(bases, datos)));

        Docente docente = new Docente("Dra. Lucia", "Profesorado universitario");
        docente.asignarCarga(prog, 6);
        docente.asignarCarga(datos, 8);

        System.out.println("=== Validacion academica ===");
        System.out.println(facultad.validarCarreras());
        System.out.println(docente);
        System.out.println("Carga horaria total del docente: " + docente.cargaTotal() + " horas");
    }

    static class Facultad {
        private final String nombre;
        private final List<Carrera> carreras = new ArrayList<>();

        public Facultad(String nombre) {
            this.nombre = nombre;
        }

        public Carrera agregarCarrera(String nombreCarrera) {
            Carrera carrera = new Carrera(this, nombreCarrera);
            carreras.add(carrera);
            return carrera;
        }

        public String validarCarreras() {
            return carreras.stream().map(Carrera::validarEstructura).collect(Collectors.joining("\n"));
        }
    }

    static class Carrera {
        private final Facultad facultad;
        private final String nombre;
        private PlanEstudios planEstudios;
        private final List<Materia> materias = new ArrayList<>();

        public Carrera(Facultad facultad, String nombre) {
            this.facultad = facultad;
            this.nombre = nombre;
        }

        public void agregarMateria(Materia materia) {
            materias.add(materia);
        }

        public void setPlanEstudios(PlanEstudios planEstudios) {
            this.planEstudios = planEstudios;
        }

        public String validarEstructura() {
            if (planEstudios == null) {
                return String.format("Carrera %s sin plan de estudios asignado.", nombre);
            }
            if (planEstudios.getMaterias().isEmpty()) {
                return String.format("Carrera %s tiene un plan de estudios vacio.", nombre);
            }
            return String.format("Carrera %s valida con plan %s.", nombre, planEstudios.getNombre());
        }
    }

    static class PlanEstudios {
        private final String nombre;
        private final List<Materia> materias;

        public PlanEstudios(String nombre, List<Materia> materias) {
            this.nombre = nombre;
            this.materias = new ArrayList<>(materias);
        }

        public String getNombre() {
            return nombre;
        }

        public List<Materia> getMaterias() {
            return materias;
        }
    }

    static class Materia {
        private final String nombre;
        private final int cargaHoraria;

        public Materia(String nombre, int cargaHoraria) {
            this.nombre = nombre;
            this.cargaHoraria = cargaHoraria;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCargaHoraria() {
            return cargaHoraria;
        }
    }

    static class Docente {
        private final String nombre;
        private final String titulo;
        private final Map<Materia, Integer> asignaciones = new HashMap<>();

        public Docente(String nombre, String titulo) {
            this.nombre = nombre;
            this.titulo = titulo;
        }

        public void asignarCarga(Materia materia, int horas) {
            asignaciones.put(materia, horas);
        }

        public int cargaTotal() {
            return asignaciones.values().stream().mapToInt(Integer::intValue).sum();
        }

        @Override
        public String toString() {
            String materias = asignaciones.entrySet().stream()
                .map(e -> e.getKey().getNombre() + " (" + e.getValue() + "h)")
                .collect(Collectors.joining(", "));
            return String.format("Docente %s - %s - asignaciones: %s", nombre, titulo, materias);
        }
    }
}
