package com.tp3.ejercicio3;

public class TarjetaCredito implements PasarelaPago {
    private String numero;
    private String nombreTitular;
    private String cvv;
    private boolean conectado;

    public TarjetaCredito(String numero, String nombreTitular, String cvv) {
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.cvv = cvv;
        this.conectado = false;
    }

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("[TARJETA CRÉDITO] Conectando con el banco...");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("[TARJETA CRÉDITO] Desconectado del banco.");
    }

    @Override
    public boolean validar() {
        if (!conectado) {
            System.out.println("[TARJETA CRÉDITO] Error: no está conectado");
            return false;
        }
        System.out.println("[TARJETA CRÉDITO] Validando CVV...");
        return cvv.length() == 3;
    }

    @Override
    public void procesar(double monto) {
        if (!validar()) {
            System.out.println("[TARJETA CRÉDITO] No se puede procesar el pago.");
            return;
        }
        System.out.println("[TARJETA CRÉDITO] Procesando $" + monto + " en tarjeta " + numero);
        System.out.println("[TARJETA CRÉDITO] ✓ Pago autorizado por el banco");
    }
}
