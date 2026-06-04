package com.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {
        Serie serie = new Serie("Codigos del Futuro");
        Temporada temporada1 = serie.agregarTemporada(1);
        Temporada temporada2 = serie.agregarTemporada(2);

        Actor actor1 = new Actor("Leo Rios");
        Actor actor2 = new Actor("Maria Vega");
        Actor actor3 = new Actor("Diego Cruz");

        temporada1.agregarEpisodio("Piloto", 42, List.of(actor1, actor2));
        temporada1.agregarEpisodio("Algoritmos", 45, List.of(actor1, actor3));
        temporada2.agregarEpisodio("Redes", 48, List.of(actor2, actor3));

        System.out.println("=== Serie de streaming ===");
        System.out.println(serie);
        System.out.println("Duracion total: " + serie.duracionTotal() + " minutos");
        System.out.println("Actores involucrados: " + serie.actoresUnicos());
    }

    static class Serie {
        private final String titulo;
        private final List<Temporada> temporadas = new ArrayList<>();

        public Serie(String titulo) {
            this.titulo = titulo;
        }

        public Temporada agregarTemporada(int numero) {
            Temporada temporada = new Temporada(this, numero);
            temporadas.add(temporada);
            return temporada;
        }

        public int duracionTotal() {
            return temporadas.stream().mapToInt(Temporada::duracionTotal).sum();
        }

        public String actoresUnicos() {
            Set<String> actores = new HashSet<>();
            for (Temporada temporada : temporadas) {
                for (Episodio episodio : temporada.getEpisodios()) {
                    for (Actor actor : episodio.getActores()) {
                        actores.add(actor.getNombre());
                    }
                }
            }
            return String.join(", ", actores);
        }

        @Override
        public String toString() {
            return String.format("Serie %s - temporadas: %d", titulo, temporadas.size());
        }
    }

    static class Temporada {
        private final Serie serie;
        private final int numero;
        private final List<Episodio> episodios = new ArrayList<>();

        public Temporada(Serie serie, int numero) {
            this.serie = serie;
            this.numero = numero;
        }

        public void agregarEpisodio(String titulo, int duracionMinutos, List<Actor> actores) {
            episodios.add(new Episodio(this, titulo, duracionMinutos, actores));
        }

        public int duracionTotal() {
            return episodios.stream().mapToInt(Episodio::getDuracionMinutos).sum();
        }

        public List<Episodio> getEpisodios() {
            return episodios;
        }
    }

    static class Episodio {
        private final Temporada temporada;
        private final String titulo;
        private final int duracionMinutos;
        private final List<Actor> actores;

        public Episodio(Temporada temporada, String titulo, int duracionMinutos, List<Actor> actores) {
            this.temporada = temporada;
            this.titulo = titulo;
            this.duracionMinutos = duracionMinutos;
            this.actores = new ArrayList<>(actores);
        }

        public int getDuracionMinutos() {
            return duracionMinutos;
        }

        public List<Actor> getActores() {
            return actores;
        }
    }

    static class Actor {
        private final String nombre;

        public Actor(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
}
