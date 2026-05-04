package com.tp3.ejercicio3;

public class PayPal implements PasarelaPago {
    private String email;
    private String password;
    private boolean conectado;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
        this.conectado = false;
    }

    @Override
    public void conectar() {
        conectado = true;
        System.out.println("[PAYPAL] Conectando a servidores de PayPal...");
    }

    @Override
    public void desconectar() {
        conectado = false;
        System.out.println("[PAYPAL] Sesión cerrada en PayPal.");
    }

    @Override
    public boolean validar() {
        if (!conectado) {
            System.out.println("[PAYPAL] Error: no está conectado a PayPal");
            return false;
        }
        System.out.println("[PAYPAL] Validando credenciales...");
        return !email.isEmpty() && !password.isEmpty();
    }

    @Override
    public void procesar(double monto) {
        if (!validar()) {
            System.out.println("[PAYPAL] No se puede procesar el pago.");
            return;
        }
        System.out.println("[PAYPAL] Procesando $" + monto + " en cuenta " + email);
        System.out.println("[PAYPAL] ✓ Transacción completada exitosamente");
    }
}
