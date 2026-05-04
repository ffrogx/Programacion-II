package com.tp3.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        System.out.println("====== EJERCICIO 5: MOTOR DE VIDEOJUEGO DE ROL ======\n");

        // Crear entidades del juego
        GuerreroHumano guerrero = new GuerreroHumano("Conan", 10, 10);
        MagoElfo mago = new MagoElfo("Legolas", 20, 20);
        Orco orco = new Orco(30, 30);
        Dragon dragon = new Dragon(40, 40);

        // Lista de todas las entidades espaciales
        List<EntidadEspacial> entidades = new ArrayList<>();
        entidades.add(guerrero);
        entidades.add(mago);
        entidades.add(orco);
        entidades.add(dragon);

        System.out.println("====== DIBUJANDO ENTIDADES ======\n");
        for (EntidadEspacial entidad : entidades) {
            entidad.dibujar();
        }

        System.out.println("\n====== ACTUALIZANDO COORDENADAS ======\n");
        guerrero.actualizarCoordenadas(15, 15);
        mago.actualizarCoordenadas(25, 25);
        orco.actualizarCoordenadas(35, 35);
        dragon.actualizarCoordenadas(45, 45);

        System.out.println("\n====== COMIENZA LA BATALLA ======\n");

        // Lista de seres vivos
        List<SerVivo> seresVivos = new ArrayList<>();
        seresVivos.add(guerrero);
        seresVivos.add(mago);
        seresVivos.add(orco);
        seresVivos.add(dragon);

        System.out.println("Estado inicial de los seres vivos:");
        for (SerVivo ser : seresVivos) {
            System.out.println(ser.getClass().getSimpleName() + " - Vida: " + ser.getPuntosVida());
        }

        System.out.println("\n--- Ronda 1 ---\n");

        // El guerrero ataca al orco
        guerrero.atacarConEspada(orco);

        // El mago lanza un hechizo
        System.out.println();
        mago.lanzarHechizo("Bola de Fuego", 40, orco);

        System.out.println();

        // El orco ataca al guerrero
        orco.golpear(guerrero);

        System.out.println();

        // El dragón lanza un hechizo
        dragon.lanzarHechizo("Rayo Mágico", 35, mago);

        System.out.println();

        System.out.println("--- Ronda 2 ---\n");

        // El mago usa su segundo hechizo contra el dragón
        mago.lanzarHechizo("Hielo", 40, dragon);

        System.out.println();

        // El dragón escupe fuego
        dragon.escupirFuego(guerrero);

        System.out.println("\n====== ESTADO FINAL DE SUPERVIVENCIA ======\n");

        System.out.println("SERES VIVOS:");
        for (SerVivo ser : seresVivos) {
            String estado = ser.estáVivo() ? "✓ Vivo" : "✗ Muerto";
            System.out.println(ser.getClass().getSimpleName() + " - " + estado + " (Vida: " + ser.getPuntosVida() + "/" + ser.getVidaMaxima() + ")");
        }

        System.out.println("\n====== HABILIDADES MÁGICAS ======\n");

        // Lista de entidades que pueden lanzar hechizos
        List<LanzarHechizos> magos = new ArrayList<>();
        magos.add(mago);
        magos.add(dragon);

        System.out.println("Entidades con capacidad mágica: " + magos.size());
        for (LanzarHechizos mago_obj : magos) {
            System.out.println("- " + mago_obj.getClass().getSimpleName());
        }

        System.out.println("\nEntidades sin capacidad mágica:");
        System.out.println("- Guerrero Humano");
        System.out.println("- Orco");
    }
}
