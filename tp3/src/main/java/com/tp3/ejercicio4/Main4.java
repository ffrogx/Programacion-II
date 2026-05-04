package com.tp3.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("====== EJERCICIO 4: ECOSISTEMA DE DISPOSITIVOS INTELIGENTES ======\n");

        // Crear dispositivos
        CamaraSeguridad camara = new CamaraSeguridad("Hikvision", "DS-2CD1143G0");
        TermostroInteligente termostro = new TermostroInteligente("Nest", 22.5);
        Smartphone telefono = new Smartphone("Apple", "iPhone 15");

        System.out.println("DISPOSITIVOS EN LA CASA INTELIGENTE:\n");
        camara.mostrarInfo();
        termostro.mostrarInfo();
        telefono.mostrarInfo();

        System.out.println("====== OPERACIONES ======\n");

        // Conectar a WiFi solo aquellos dispositivos que lo soportan
        System.out.println("Conectando dispositivos a la red WiFi_Casa...\n");

        // Camara de seguridad no soporta WiFi, pero el smartphone y termostro sí
        List<ConectarWiFi> dispositivosWiFi = new ArrayList<>();
        dispositivosWiFi.add(termostro);
        dispositivosWiFi.add(telefono);

        for (ConectarWiFi dispositivo : dispositivosWiFi) {
            dispositivo.conectarWiFi("WiFi_Casa");
        }

        System.out.println();

        // Tomar fotos solo con dispositivos que lo soportan
        System.out.println("Capturando fotos con dispositivos habilitados...\n");

        List<TomarFoto> dispositivosFoto = new ArrayList<>();
        dispositivosFoto.add(camara);
        dispositivosFoto.add(telefono);

        for (TomarFoto dispositivo : dispositivosFoto) {
            dispositivo.capturarFoto();
        }

        System.out.println();

        // Desconectar
        System.out.println("Desconectando de WiFi...\n");
        for (ConectarWiFi dispositivo : dispositivosWiFi) {
            dispositivo.desconectarWiFi();
        }
    }
}
