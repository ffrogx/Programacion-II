package com.tp3.ejercicio5;

public class GuerreroHumano extends Personaje {
    private int fuerzaAtaque;

    public GuerreroHumano(String nombre, double x, double y) {
        super(nombre, x, y, 150);
        this.fuerzaAtaque = 30;
    }

    public void atacarConEspada(SerVivo objetivo) {
        System.out.println("[GUERRERO " + nombre + "] ¡Ataca con espada!");
        objetivo.recibirDanio(fuerzaAtaque);
    }

    @Override
    public void dibujar() {
        System.out.println("[GUERRERO HUMANO] " + nombre + " dibujado en (" + x + ", " + y + ")");
    }

    public int getFuerzaAtaque() {
        return fuerzaAtaque;
    }
}
