package com.tp3.ejercicio5;

public class Orco extends Monstruo {
    private int fuerzaGolpe;

    public Orco(double x, double y) {
        super("Orco", x, y, 120);
        this.fuerzaGolpe = 25;
    }

    public void golpear(SerVivo objetivo) {
        System.out.println("[ORCO] ¡Ataca ferozmente!");
        objetivo.recibirDanio(fuerzaGolpe);
    }

    @Override
    public void dibujar() {
        System.out.println("[ORCO] dibujado en (" + x + ", " + y + ")");
    }
}
