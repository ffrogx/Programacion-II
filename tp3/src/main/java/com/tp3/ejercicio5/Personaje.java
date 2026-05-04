package com.tp3.ejercicio5;

public abstract class Personaje extends SerVivo {
    protected String nombre;

    public Personaje(String nombre, double x, double y, int vidaMaxima) {
        super(x, y, vidaMaxima);
        this.nombre = nombre;
    }

    @Override
    public void dibujar() {
        System.out.println("[PERSONAJE JUGABLE] " + nombre + " dibujado en (" + x + ", " + y + ")");
    }

    public String getNombre() {
        return nombre;
    }
}
