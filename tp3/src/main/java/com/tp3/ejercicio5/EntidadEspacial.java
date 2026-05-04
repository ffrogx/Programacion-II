package com.tp3.ejercicio5;

public abstract class EntidadEspacial {
    protected double x;
    protected double y;

    public EntidadEspacial(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void dibujar();

    public void actualizarCoordenadas(double nuevoX, double nuevoY) {
        this.x = nuevoX;
        this.y = nuevoY;
        System.out.println(getClass().getSimpleName() + " se movió a (" + x + ", " + y + ")");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
