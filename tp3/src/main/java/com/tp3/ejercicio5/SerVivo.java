package com.tp3.ejercicio5;

public abstract class SerVivo extends EntidadEspacial {
    protected int puntosVida;
    protected int vidaMaxima;

    public SerVivo(double x, double y, int vidaMaxima) {
        super(x, y);
        this.vidaMaxima = vidaMaxima;
        this.puntosVida = vidaMaxima;
    }

    public void recibirDanio(int danio) {
        puntosVida -= danio;
        System.out.println(getClass().getSimpleName() + " recibió " + danio + " de daño. Vida: " + puntosVida);
    }

    public boolean estáVivo() {
        return puntosVida > 0;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    @Override
    public abstract void dibujar();
}
