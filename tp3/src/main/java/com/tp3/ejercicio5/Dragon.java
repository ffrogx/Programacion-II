package com.tp3.ejercicio5;

public class Dragon extends Monstruo implements LanzarHechizos {
    private int poderMagico;

    public Dragon(double x, double y) {
        super("Dragón", x, y, 300);
        this.poderMagico = 60;
    }

    @Override
    public void lanzarHechizo(String nombreHechizo, int danio, SerVivo objetivo) {
        System.out.println("[DRAGÓN] ¡Lanza " + nombreHechizo + " mágico!");
        objetivo.recibirDanio(danio + poderMagico);
    }

    public void escupirFuego(SerVivo objetivo) {
        System.out.println("[DRAGÓN] ¡Escupe fuego!");
        objetivo.recibirDanio(50);
    }

    @Override
    public void dibujar() {
        System.out.println("[DRAGÓN] dibujado en (" + x + ", " + y + ")");
    }
}
