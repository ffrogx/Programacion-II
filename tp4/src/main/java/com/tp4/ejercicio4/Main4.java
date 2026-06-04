package com.tp4.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        Edificio edificio = new Edificio("Torres Global", "Cordoba");

        Oficina oficina1 = edificio.agregarOficina("A1", 4);
        Oficina oficina2 = edificio.agregarOficina("B2", 6);

        oficina1.agregarMobiliario(new Mobiliario("Escritorio"));
        oficina1.agregarMobiliario(new Mobiliario("Silla ergonomica"));
        oficina2.agregarMobiliario(new Mobiliario("Mesa de reuniones"));

        System.out.println("=== Oficinas antes de remodelar ===");
        System.out.println(edificio.listarOficinasDisponibles());

        oficina1.remodelar(deposito);

        System.out.println("\n=== Oficinas despues de remodelar oficina A1 ===");
        System.out.println(edificio.listarOficinasDisponibles());
        System.out.println("\n=== Deposito general ===");
        System.out.println(deposito);
    }

    static class Edificio {
        private final String nombre;
        private final String ciudad;
        private final List<Oficina> oficinas = new ArrayList<>();

        public Edificio(String nombre, String ciudad) {
            this.nombre = nombre;
            this.ciudad = ciudad;
        }

        public Oficina agregarOficina(String codigo, int capacidadPersonas) {
            Oficina oficina = new Oficina(this, codigo, capacidadPersonas);
            oficinas.add(oficina);
            return oficina;
        }

        public String listarOficinasDisponibles() {
            return oficinas.stream().map(Oficina::toString).collect(Collectors.joining("\n"));
        }

        @Override
        public String toString() {
            return String.format("Edificio %s (%s)", nombre, ciudad);
        }
    }

    static class Oficina {
        private final Edificio edificio;
        private final String codigo;
        private final int capacidadPersonas;
        private final List<Mobiliario> mobiliario = new ArrayList<>();

        public Oficina(Edificio edificio, String codigo, int capacidadPersonas) {
            this.edificio = edificio;
            this.codigo = codigo;
            this.capacidadPersonas = capacidadPersonas;
        }

        public void agregarMobiliario(Mobiliario item) {
            mobiliario.add(item);
        }

        public void remodelar(Deposito deposito) {
            deposito.recibirMobiliario(new ArrayList<>(mobiliario));
            mobiliario.clear();
        }

        @Override
        public String toString() {
            return String.format("Oficina %s [%d pax] - Mobiliario: %s", codigo, capacidadPersonas,
                mobiliario.stream().map(Mobiliario::getTipo).collect(Collectors.joining(", ")));
        }
    }

    static class Mobiliario {
        private final String tipo;

        public Mobiliario(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        @Override
        public String toString() {
            return tipo;
        }
    }

    static class Deposito {
        private final List<Mobiliario> muebles = new ArrayList<>();

        public void recibirMobiliario(List<Mobiliario> items) {
            muebles.addAll(items);
        }

        @Override
        public String toString() {
            if (muebles.isEmpty()) {
                return "Deposito vacio";
            }
            return muebles.stream().map(Mobiliario::getTipo).collect(Collectors.joining(", "));
        }
    }
}
