# TP3 - Herencia, Clases Abstractas e Interfaces

## Descripción General
Este trabajo práctico implementa 5 ejercicios sobre los conceptos de Herencia, Clases Abstractas e Interfaces en Java, aplicando Polimorfismo para procesar colecciones de objetos heterogéneos.

## Ejercicios Implementados

### Ejercicio 1: Sistema de Flota de Transporte
**Objetivo:** Gestionar una flota de vehículos con diferentes tipos.

**Estructura:**
- `Vehiculo` (clase abstracta): Define propiedades comunes
  - `marca`: La marca del vehículo
  - `modelo`: El modelo del vehículo
  - `tarifaBase`: Tarifa base de alquiler
  - Método abstracto: `mostrarDetalles()`

- `Furgoneta` (extends Vehiculo): Vehículo de carga
  - Atributo adicional: `capacidadCarga` (en kg)

- `Motocicleta` (extends Vehiculo): Vehículo de reparto
  - Atributo adicional: `cilindrada` (en cc)

**Ejecución:**
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.tp3.ejercicio1.Main1"
```

---

### Ejercicio 2: Gestor de Suscripciones de Streaming
**Objetivo:** Calcular ingresos mensuales con diferentes planes de suscripción.

**Estructura:**
- `Suscripcion` (clase abstracta): Define datos comunes
  - `correoElectronico`: Email del titular
  - `numeroCliente`: ID único
  - `costoBase`: Costo base del servicio
  - Método abstracto: `calcularCostoMensual()`

- `PlanBasico` (extends Suscripcion): Cobra solo el costo base

- `PlanFamiliar` (extends Suscripcion): Suma costo por cada perfil adicional
  - `perfilesAdicionales`: Número de perfiles extra
  - `costoAdionalPorPerfil`: Monto por cada perfil

- `PlanPremium` (extends Suscripcion): Suma cargo extra por 4K y descargas
  - `cargoExtra4K`: Cargo fijo por resolución 4K
  - `descargas`: Habilita descargas offline

**Ejecución:**
```bash
mvn exec:java -Dexec.mainClass="com.tp3.ejercicio2.Main2"
```

---

### Ejercicio 3: Pasarela de Pagos E-commerce
**Objetivo:** Procesar pagos mediante diferentes métodos de forma uniforme.

**Estructura:**
- `PasarelaPago` (interfaz): Contrato para procesar pagos
  - `procesar(double monto)`: Procesa el monto
  - `validar()`: Valida las credenciales
  - `conectar()`: Conecta con el servidor
  - `desconectar()`: Desconecta del servidor

- `TarjetaCredito` (implements PasarelaPago): Pago con tarjeta
  - Conecta con el banco y valida CVV

- `PayPal` (implements PasarelaPago): Pago mediante PayPal
  - Conecta con servidores PayPal y valida credenciales

- `Criptomonedas` (implements PasarelaPago): Pago con criptomonedas
  - Conecta con blockchain y verifica billetera

**Ejecución:**
```bash
mvn exec:java -Dexec.mainClass="com.tp3.ejercicio3.Main3"
```

---

### Ejercicio 4: Ecosistema de Dispositivos Inteligentes
**Objetivo:** Modelar dispositivos inteligentes con capacidades múltiples.

**Estructura:**
- `TomarFoto` (interfaz): Capacidad para capturar fotografías
  - `capturarFoto()`: Toma una foto

- `ConectarWiFi` (interfaz): Capacidad para conectarse a WiFi
  - `conectarWiFi(String nombreRed)`: Se conecta a una red
  - `desconectarWiFi()`: Se desconecta de la red

- `CamaraSeguridad` (implements TomarFoto): Solo toma fotos

- `TermostroInteligente` (implements ConectarWiFi): Solo se conecta a WiFi

- `Smartphone` (implements TomarFoto, ConectarWiFi): Tiene ambas capacidades

**Ejecución:**
```bash
mvn exec:java -Dexec.mainClass="com.tp3.ejercicio4.Main4"
```

---

### Ejercicio 5: Motor de Videojuego de Rol
**Objetivo:** Simular un sistema de batalla con herencia múltiple de comportamientos.

**Estructura:**
- `EntidadEspacial` (clase abstracta): Base de todas las entidades
  - `x`, `y`: Coordenadas en pantalla
  - `actualizarCoordenadas()`: Mueve la entidad
  - `dibujar()`: Dibuja en pantalla

- `SerVivo` (extends EntidadEspacial): Seres con puntos de vida
  - `puntosVida`: Vida actual
  - `vidaMaxima`: Vida máxima
  - `recibirDanio()`: Reduce vida
  - `estáVivo()`: Verifica supervivencia

- `Personaje` (extends SerVivo): Personajes jugables
  
- `Monstruo` (extends SerVivo): Enemigos del juego

- `LanzarHechizos` (interfaz): Capacidad mágica
  - `lanzarHechizo()`: Lanza un ataque mágico

- **Clases concretas:**
  - `GuerreroHumano` (extends Personaje): Ataca con espada
  - `MagoElfo` (extends Personaje, implements LanzarHechizos): Lanza hechizos
  - `Orco` (extends Monstruo): Golpea ferozmente
  - `Dragon` (extends Monstruo, implements LanzarHechizos): Lanza hechizos y fuego

**Ejecución:**
```bash
mvn exec:java -Dexec.mainClass="com.tp3.ejercicio5.Main5"
```

---

## Compilar Todo el Proyecto
```bash
mvn clean compile
```

## Conceptos Aplicados

### 1. Herencia
- Uso de clases base que definen propiedades comunes
- Especialización mediante subclases con atributos específicos
- Reutilización de código a través de `extends`

### 2. Clases Abstractas
- Definición de contratos mediante métodos abstractos
- Prevención de instanciación directa
- Garantía de que subclases implementen métodos específicos

### 3. Interfaces
- Múltiples comportamientos independientes
- Resolución de "herencia múltiple" en Java
- Contratos sin acoplamiento a implementación

### 4. Polimorfismo
- Procesamiento de colecciones heterogéneas
- Llamada a métodos específicos según tipo real
- Simplificación de lógica mediante referencias base

## Observaciones

- Todos los ejercicios demuestran cómo usar herencia y polimorfismo para simplificar código
- Las interfaces permiten modelar comportamientos comunes sin herencia directa
- Las clases abstractas garantizan una estructura consistente sin permitir instanciación directa
- El uso de `List<TipoBase>` permite procesar objetos heterogéneos de forma uniforme
