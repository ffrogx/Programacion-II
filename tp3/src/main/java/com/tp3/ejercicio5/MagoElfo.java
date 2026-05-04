package com.tp3.ejercicio5;

public class MagoElfo extends Personaje implements LanzarHechizos {
    private int mana;
    private int manaMaximo;

    public MagoElfo(String nombre, double x, double y) {
        super(nombre, x, y, 100);
        this.manaMaximo = 200;
        this.mana = manaMaximo;
    }

    @Override
    public void lanzarHechizo(String nombreHechizo, int danio, SerVivo objetivo) {
        if (mana < 50) {
            System.out.println("[MAGO " + nombre + "] No hay suficiente maná!");
            return;
        }
        mana -= 50;
        System.out.println("[MAGO " + nombre + "] ¡Lanza " + nombreHechizo + "!");
        objetivo.recibirDanio(danio);
        System.out.println("[MAGO " + nombre + "] Maná restante: " + mana);
    }

    @Override
    public void dibujar() {
        System.out.println("[MAGO ELFO] " + nombre + " dibujado en (" + x + ", " + y + ")");
    }

    public int getMana() {
        return mana;
    }
}
