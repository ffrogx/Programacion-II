package com.tp3.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("====== EJERCICIO 3: PASARELA DE PAGOS E-COMMERCE ======\n");

        // Simular diferentes métodos de pago
        List<PasarelaPago> pagos = new ArrayList<>();
        pagos.add(new TarjetaCredito("4532-1234-5678-9010", "Juan García", "123"));
        pagos.add(new PayPal("cliente@example.com", "seguro123"));
        pagos.add(new Criptomonedas("1A1z7agoat4JNFSreZnwQN2emt6QTvjkm", "Bitcoin"));

        double montoCompra = 150.50;

        System.out.println("Procesando compra de $" + montoCompra + "\n");

        // Procesar pago con cada método
        for (PasarelaPago pago : pagos) {
            pago.conectar();
            pago.procesar(montoCompra);
            pago.desconectar();
            System.out.println();
        }

        System.out.println("====== RESUMEN DE TRANSACCIONES ======");
        System.out.println("Total de métodos de pago procesados: " + pagos.size());
        System.out.println("Monto procesado por método: $" + montoCompra);
        System.out.println("Ingresos totales: $" + (montoCompra * pagos.size()));
    }
}
