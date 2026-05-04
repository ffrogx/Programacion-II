package com.tp3.ejercicio5;

public abstract class Monstruo extends SerVivo {
    protected String tipo;

    public Monstruo(String tipo, double x, double y, int vidaMaxima) {
        super(x, y, vidaMaxima);
        this.tipo = tipo;
    }

    @Override
    public void dibujar() {
        System.out.println("[MONSTRUO HOSTIL] " + tipo + " dibujado en (" + x + ", " + y + ")");
    }

    public String getTipo() {
        return tipo;
    }
}
