package com.tp3.ejercicio3;

public interface PasarelaPago {
    void procesar(double monto);
    boolean validar();
    void conectar();
    void desconectar();
}
