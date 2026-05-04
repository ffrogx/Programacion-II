package com.tp3.ejercicio4;

public class TermostroInteligente implements ConectarWiFi {
    private String marca;
    private double temperaturaActual;
    private boolean conectado;

    public TermostroInteligente(String marca, double temperaturaActual) {
        this.marca = marca;
        this.temperaturaActual = temperaturaActual;
        this.conectado = false;
    }

    @Override
    public void conectarWiFi(String nombreRed) {
        conectado = true;
        System.out.println("[TERMOSTRO " + marca + "] Conectándose a red: " + nombreRed + "...");
        System.out.println("[TERMOSTRO " + marca + "] ✓ Conectado a " + nombreRed);
    }

    @Override
    public void desconectarWiFi() {
        conectado = false;
        System.out.println("[TERMOSTRO " + marca + "] Desconectado de WiFi");
    }

    public void mostrarInfo() {
        System.out.println("Dispositivo: Termostro Inteligente " + marca);
        System.out.println("Capacidad: Conectarse a WiFi");
        System.out.println("Temperatura actual: " + temperaturaActual + "°C");
        System.out.println();
    }

    public boolean estaConectado() {
        return conectado;
    }
}
