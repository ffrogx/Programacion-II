package com.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ana Perez");
        Billetera billetera = usuario.crearBilletera();

        billetera.agregarCuenta(new CuentaPesos(1, 25000.00));
        billetera.agregarCuenta(new CuentaDolares(2, 650.00));
        billetera.agregarCuenta(new CuentaCripto(3, 0.75));

        billetera.agregarTarjeta(new TarjetaCredito("Visa Platinum"));
        billetera.agregarTarjeta(new TarjetaCredito("Mastercard Gold"));

        System.out.println("=== Billetera inicial ===");
        System.out.println(billetera.detalle());

        billetera.transferirEntreCuentas(1, 2, 5000.00);
        System.out.println("\nDespues de transferir $5000 de pesos a dolares:");
        System.out.println(billetera.detalle());

        Usuario usuario2 = new Usuario("Bruno Gomez");
        Billetera nuevaBilletera = usuario2.crearBilletera();
        usuario.migrarTarjeta("Visa Platinum", nuevaBilletera);

        System.out.println("\n=== Nueva billetera despues de migrar tarjeta ===");
        System.out.println(nuevaBilletera.detalle());

        billetera.cerrar();
        System.out.println("\n=== Billetera cerrada ===");
        System.out.println(billetera.detalle());
    }

    static class Usuario {
        private final String nombre;
        private Billetera billetera;

        public Usuario(String nombre) {
            this.nombre = nombre;
        }

        public Billetera crearBilletera() {
            this.billetera = new Billetera(this);
            return billetera;
        }

        public void migrarTarjeta(String nombreTarjeta, Billetera nuevaBilletera) {
            if (billetera == null) {
                throw new IllegalStateException("El usuario no tiene billetera activa.");
            }
            TarjetaCredito tarjeta = billetera.removerTarjeta(nombreTarjeta);
            if (tarjeta != null) {
                nuevaBilletera.agregarTarjeta(tarjeta);
            }
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    static class Billetera {
        private final Usuario propietario;
        private final List<Cuenta> cuentas = new ArrayList<>();
        private final List<TarjetaCredito> tarjetas = new ArrayList<>();
        private boolean activa = true;

        public Billetera(Usuario propietario) {
            this.propietario = propietario;
        }

        public void agregarCuenta(Cuenta cuenta) {
            if (!activa) {
                throw new IllegalStateException("La billetera esta cerrada.");
            }
            cuentas.add(cuenta);
        }

        public void agregarTarjeta(TarjetaCredito tarjeta) {
            if (!activa) {
                throw new IllegalStateException("La billetera esta cerrada.");
            }
            tarjeta.asignarA(this);
            tarjetas.add(tarjeta);
        }

        public TarjetaCredito removerTarjeta(String nombre) {
            for (TarjetaCredito tarjeta : new ArrayList<>(tarjetas)) {
                if (tarjeta.getNombre().equals(nombre)) {
                    tarjetas.remove(tarjeta);
                    tarjeta.removerDeBilletera();
                    return tarjeta;
                }
            }
            return null;
        }

        public double saldoConsolidado() {
            return cuentas.stream().mapToDouble(Cuenta::getSaldo).sum();
        }

        public void transferirEntreCuentas(int origenId, int destinoId, double monto) {
            Cuenta origen = buscarCuenta(origenId);
            Cuenta destino = buscarCuenta(destinoId);
            if (origen == null || destino == null) {
                throw new IllegalArgumentException("Cuenta origen o destino no encontrada.");
            }
            origen.debitar(monto);
            destino.acreditar(monto);
        }

        private Cuenta buscarCuenta(int id) {
            return cuentas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        }

        public void cerrar() {
            cuentas.clear();
            activa = false;
        }

        public String detalle() {
            StringBuilder builder = new StringBuilder();
            builder.append("Usuario: ").append(propietario).append("\n");
            builder.append("Activa: ").append(activa).append("\n");
            builder.append("Saldo consolidado: $").append(String.format("%.2f", saldoConsolidado())).append("\n");
            builder.append("Cuentas:\n");
            cuentas.forEach(c -> builder.append("  - ").append(c.descripcion()).append("\n"));
            builder.append("Tarjetas:\n");
            tarjetas.forEach(t -> builder.append("  - ").append(t.getNombre()).append("\n"));
            return builder.toString();
        }
    }

    abstract static class Cuenta {
        private final int id;
        private double saldo;

        public Cuenta(int id, double saldoInicial) {
            this.id = id;
            this.saldo = saldoInicial;
        }

        public int getId() {
            return id;
        }

        public double getSaldo() {
            return saldo;
        }

        public void acreditar(double monto) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser positivo.");
            }
            saldo += monto;
        }

        public void debitar(double monto) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser positivo.");
            }
            if (monto > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }
            saldo -= monto;
        }

        public abstract String descripcion();
    }

    static class CuentaPesos extends Cuenta {
        public CuentaPesos(int id, double saldoInicial) {
            super(id, saldoInicial);
        }

        @Override
        public String descripcion() {
            return String.format("Cuenta en pesos #%d: $%.2f", getId(), getSaldo());
        }
    }

    static class CuentaDolares extends Cuenta {
        public CuentaDolares(int id, double saldoInicial) {
            super(id, saldoInicial);
        }

        @Override
        public String descripcion() {
            return String.format("Cuenta en dolares #%d: $%.2f", getId(), getSaldo());
        }
    }

    static class CuentaCripto extends Cuenta {
        public CuentaCripto(int id, double saldoInicial) {
            super(id, saldoInicial);
        }

        @Override
        public String descripcion() {
            return String.format("Cuenta cripto #%d: %.4f monedas", getId(), getSaldo());
        }
    }

    static class TarjetaCredito {
        private final String nombre;
        private Billetera billetera;

        public TarjetaCredito(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void asignarA(Billetera billetera) {
            this.billetera = billetera;
        }

        public void removerDeBilletera() {
            this.billetera = null;
        }
    }
}
