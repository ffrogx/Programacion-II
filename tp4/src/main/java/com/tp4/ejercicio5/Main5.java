package com.tp4.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("K1NG", "Ana", 1200);
        Jugador j2 = new Jugador("Shadow", "Bruno", 900);
        Jugador j3 = new Jugador("Nova", "Clara", 1100);

        Equipo equipo = new Equipo("Titanes");
        equipo.agregarJugador(j1);
        equipo.agregarJugador(j2);
        equipo.agregarJugador(j3);
        equipo.agregarTrofeo(new Trofeo("Campeon Regional", 2025));
        equipo.agregarTrofeo(new Trofeo("Mejor Defensa", 2026));

        System.out.println("=== Equipo activo ===");
        System.out.println(equipo);

        equipo.disolver();

        System.out.println("\n=== Equipo disuelto ===");
        System.out.println(equipo);
        System.out.println("Jugadores libres: " + listaJugadoresLibres(j1, j2, j3));
    }

    private static String listaJugadoresLibres(Jugador... jugadores) {
        return List.of(jugadores).stream().map(Jugador::toString).collect(Collectors.joining(", "));
    }

    static class Jugador {
        private final String alias;
        private final String nombreReal;
        private final int rating;
        private Equipo equipo;

        public Jugador(String alias, String nombreReal, int rating) {
            this.alias = alias;
            this.nombreReal = nombreReal;
            this.rating = rating;
        }

        public void asignarA(Equipo equipo) {
            this.equipo = equipo;
        }

        public void liberar() {
            this.equipo = null;
        }

        @Override
        public String toString() {
            return String.format("%s (%s) - rating %d%s", alias, nombreReal, rating,
                equipo == null ? "" : " - equipo " + equipo.getNombre());
        }
    }

    static class Equipo {
        private final String nombre;
        private final List<Jugador> jugadores = new ArrayList<>();
        private final HistorialTrofeos historial = new HistorialTrofeos();
        private boolean activo = true;

        public Equipo(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void agregarJugador(Jugador jugador) {
            jugadores.add(jugador);
            jugador.asignarA(this);
        }

        public void agregarTrofeo(Trofeo trofeo) {
            historial.agregarTrofeo(trofeo);
        }

        public void disolver() {
            activo = false;
            for (Jugador jugador : jugadores) {
                jugador.liberar();
            }
            historial.invalidar();
        }

        @Override
        public String toString() {
            return String.format("Equipo %s - activo: %s - jugadores: [%s] - %s",
                nombre,
                activo,
                jugadores.stream().map(j -> j.alias).collect(Collectors.joining(", ")),
                historial);
        }
    }

    static class HistorialTrofeos {
        private final List<Trofeo> trofeos = new ArrayList<>();
        private boolean valido = true;

        public void agregarTrofeo(Trofeo trofeo) {
            if (valido) {
                trofeos.add(trofeo);
            }
        }

        public void invalidar() {
            valido = false;
            trofeos.clear();
        }

        @Override
        public String toString() {
            if (!valido) {
                return "Historial invalido";
            }
            return "Trofeos: " + trofeos.stream().map(Trofeo::toString).collect(Collectors.joining(", "));
        }
    }

    static class Trofeo {
        private final String nombre;
        private final int ano;

        public Trofeo(String nombre, int ano) {
            this.nombre = nombre;
            this.ano = ano;
        }

        @Override
        public String toString() {
            return String.format("%s (%d)", nombre, ano);
        }
    }
}
