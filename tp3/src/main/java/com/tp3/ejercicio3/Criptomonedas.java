package com.tp3.ejercicio3;

public class Criptomonedas implements PasarelaPago {
    private String billetera;
    private String tipoMoneda; // Bitcoin, Ethereum, etc
    private boolean conectado;

    public Criptomonedas(String billetera, String tipoMoneda) {
        this.billetera = billetera;
        this.tipoMoneda = tipoMoneda;
        this.conectado = false;
    }

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("[CRIPTO] Conectando a blockchain de " + tipoMoneda + "...");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("[CRIPTO] Desconectado del blockchain.");
    }

    @Override
    public boolean validar() {
        if (!conectado) {
            System.out.println("[CRIPTO] Error: no está conectado a la blockchain");
            return false;
        }
        System.out.println("[CRIPTO] Verificando saldo en billetera...");
        return !billetera.isEmpty();
    }

    @Override
    public void procesar(double monto) {
        if (!validar()) {
            System.out.println("[CRIPTO] No se puede procesar el pago.");
            return;
        }
        double cantidadCripto = monto / 50000; // Simulación: $50000 por crypto
        System.out.println("[CRIPTO] Procesando " + cantidadCripto + " " + tipoMoneda);
        System.out.println("[CRIPTO] Enviando a billetera: " + billetera);
        System.out.println("[CRIPTO] ✓ Transacción registrada en la blockchain");
    }
}
