package com.tp3.ejercicio4;

public class CamaraSeguridad implements TomarFoto {
    private String marca;
    private String modelo;

    public CamaraSeguridad(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void capturarFoto() {
        System.out.println("[CÁMARA SEGURIDAD " + marca + "] Capturando fotografía...");
        System.out.println("[CÁMARA SEGURIDAD " + marca + "] ✓ Foto guardada en memoria");
    }

    public void mostrarInfo() {
        System.out.println("Dispositivo: Cámara de Seguridad " + marca + " " + modelo);
        System.out.println("Capacidad: Tomar fotos");
        System.out.println();
    }
}
