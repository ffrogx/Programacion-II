package com.tp4.ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        Locomotora locomotora = new Locomotora("Norte 01", 5000);
        TrenAzucarero tren = new TrenAzucarero(locomotora);
        tren.agregarVagon(new VagonCanero("V1", 12000));
        tren.agregarVagon(new VagonCanero("V2", 9000));
        tren.agregarVagon(new VagonCanero("V3", 15000));

        HojaDeRuta ruta = new HojaDeRuta("Ingenio", "Puerto", 320);
        Viaje viaje = new Viaje(tren, ruta);

        System.out.println("=== Tren azucarero antes del cambio de vagon ===");
        System.out.println(viaje);

        VagonCanero vagonReasignado = tren.removerVagon("V2");
        TrenAzucarero otroTren = new TrenAzucarero(new Locomotora("Norte 02", 5000));
        if (vagonReasignado != null) {
            otroTren.agregarVagon(vagonReasignado);
        }

        System.out.println("\n=== Tren reasignado ===");
        System.out.println(otroTren);

        viaje.cancelar();
        System.out.println("\n=== Viaje cancelado ===");
        System.out.println(viaje);
    }

    static class Locomotora {
        private final String modelo;
        private final int potencia;

        public Locomotora(String modelo, int potencia) {
            this.modelo = modelo;
            this.potencia = potencia;
        }

        @Override
        public String toString() {
            return String.format("Locomotora %s (%d HP)", modelo, potencia);
        }
    }

    static class VagonCanero {
        private final String codigo;
        private final int capacidadKg;

        public VagonCanero(String codigo, int capacidadKg) {
            this.codigo = codigo;
            this.capacidadKg = capacidadKg;
        }

        public int getCapacidadKg() {
            return capacidadKg;
        }

        @Override
        public String toString() {
            return String.format("Vagon %s [%d kg]", codigo, capacidadKg);
        }
    }

    static class TrenAzucarero {
        private final Locomotora locomotora;
        private final List<VagonCanero> vagones = new ArrayList<>();

        public TrenAzucarero(Locomotora locomotora) {
            this.locomotora = locomotora;
        }

        public void agregarVagon(VagonCanero vagon) {
            vagones.add(vagon);
        }

        public VagonCanero removerVagon(String codigo) {
            for (VagonCanero vagon : new ArrayList<>(vagones)) {
                if (vagon.toString().contains(codigo)) {
                    vagones.remove(vagon);
                    return vagon;
                }
            }
            return null;
        }

        public int capacidadTotal() {
            return vagones.stream().mapToInt(VagonCanero::getCapacidadKg).sum();
        }

        @Override
        public String toString() {
            String lista = vagones.stream().map(Object::toString).collect(Collectors.joining(", "));
            return String.format("%s - Capacidad total: %d kg - Vagones: [%s]", locomotora, capacidadTotal(), lista);
        }
    }

    static class HojaDeRuta {
        private final String origen;
        private final String destino;
        private final int distanciaKm;
        private boolean valida = true;

        public HojaDeRuta(String origen, String destino, int distanciaKm) {
            this.origen = origen;
            this.destino = destino;
            this.distanciaKm = distanciaKm;
        }

        public void invalidar() {
            valida = false;
        }

        @Override
        public String toString() {
            return String.format("Hoja de ruta %s -> %s (%dkm) - valida: %s", origen, destino, distanciaKm, valida);
        }
    }

    static class Viaje {
        private final TrenAzucarero tren;
        private final HojaDeRuta hojaDeRuta;
        private boolean cancelado = false;

        public Viaje(TrenAzucarero tren, HojaDeRuta hojaDeRuta) {
            this.tren = tren;
            this.hojaDeRuta = hojaDeRuta;
        }

        public void cancelar() {
            cancelado = true;
            hojaDeRuta.invalidar();
        }

        @Override
        public String toString() {
            return String.format("Viaje: %s - Ruta: %s - cancelado: %s", tren, hojaDeRuta, cancelado);
        }
    }
}
