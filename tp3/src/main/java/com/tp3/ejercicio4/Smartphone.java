package com.tp3.ejercicio4;

public class Smartphone implements TomarFoto, ConectarWiFi {
    private String marca;
    private String modelo;
    private boolean conectado;

    public Smartphone(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.conectado = false;
    }

    @Override
    public void capturarFoto() {
        System.out.println("[SMARTPHONE " + marca + "] Abriendo cámara...");
        System.out.println("[SMARTPHONE " + marca + "] ✓ Foto capturada con " + marca + " Camera");
    }

    @Override
    public void conectarWiFi(String nombreRed) {
        conectado = true;
        System.out.println("[SMARTPHONE " + marca + "] Conectándose a " + nombreRed + "...");
        System.out.println("[SMARTPHONE " + marca + "] ✓ Conectado a " + nombreRed);
    }

    @Override
    public void desconectarWiFi() {
        conectado = false;
        System.out.println("[SMARTPHONE " + marca + "] Desconectado de WiFi");
    }

    public void mostrarInfo() {
        System.out.println("Dispositivo: Smartphone " + marca + " " + modelo);
        System.out.println("Capacidades: Tomar fotos y Conectarse a WiFi");
        System.out.println();
    }

    public boolean estaConectado() {
        return conectado;
    }
}
