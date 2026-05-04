# Ayuda para TP3: Herencia, Clases Abstractas e Interfaces

## Descripción Rápida

Este proyecto contiene **5 ejercicios prácticos** que demuestran el uso de:
- **Herencia** para reutilizar código
- **Clases Abstractas** para definir contratos
- **Interfaces** para múltiples comportamientos
- **Polimorfismo** para procesar colecciones heterogéneas

## Estructura del Proyecto

```
tp3/
├── ejercicio1/  → Sistema de Flota de Transporte
├── ejercicio2/  → Gestor de Suscripciones de Streaming
├── ejercicio3/  → Pasarela de Pagos E-commerce
├── ejercicio4/  → Ecosistema de Dispositivos Inteligentes
└── ejercicio5/  → Motor de Videojuego de Rol
```

## Compilar el Proyecto

```bash
cd tp3
.\mvnw clean compile
```

## Ejecutar Cada Ejercicio

### Ejercicio 1: Sistema de Flota de Transporte
```bash
java -cp target\classes com.tp3.ejercicio1.Main1
```
Demuestra: **Herencia**, método abstracto `mostrarDetalles()`, polimorfismo con `List<Vehiculo>`

### Ejercicio 2: Gestor de Suscripciones de Streaming
```bash
java -cp target\classes com.tp3.ejercicio2.Main2
```
Demuestra: **Clase Abstracta**, diferentes implementaciones de `calcularCostoMensual()`, procesamiento de colecciones

### Ejercicio 3: Pasarela de Pagos E-commerce
```bash
java -cp target\classes com.tp3.ejercicio3.Main3
```
Demuestra: **Interfaz** común, múltiples implementaciones, desacoplamiento

### Ejercicio 4: Ecosistema de Dispositivos Inteligentes
```bash
java -cp target\classes com.tp3.ejercicio4.Main4
```
Demuestra: **Múltiples interfaces**, composición de comportamientos, herencia múltiple de interfaces

### Ejercicio 5: Motor de Videojuego de Rol
```bash
java -cp target\classes com.tp3.ejercicio5.Main5
```
Demuestra: **Jerarquía multinivel**, interfaces transversales, polimorfismo avanzado

## Conceptos Clave

### Herencia
```java
public class Furgoneta extends Vehiculo {
    // Hereda marca, modelo, tarifaBase
    // Agrega capacidadCarga
}
```

### Clase Abstracta
```java
public abstract class Vehiculo {
    public abstract void mostrarDetalles();
}
```

### Interfaz
```java
public interface PasarelaPago {
    void procesar(double monto);
    boolean validar();
}
```

### Implementar Múltiples Interfaces
```java
public class Smartphone implements TomarFoto, ConectarWiFi {
    // Implementa métodos de ambas interfaces
}
```

## Archivos Importantes

- **README.md** - Documentación técnica detallada
- **INFORME.md** - Informe completo del trabajo
- **pom.xml** - Configuración Maven del proyecto

## Notas de Implementación

1. Cada ejercicio es **completamente independiente** en su propio package
2. Cada `MainX` demuestra el ejercicio con ejemplos prácticos
3. El código **compila sin errores** y se ejecuta correctamente
4. Todos los ejercicios muestran salida clara en consola

## Requisitos del Sistema

- Java 21 o superior
- Maven 3.6+ (se incluye Maven Wrapper)
- 2+ minutos para primera compilación (descarga dependencias)

## Troubleshooting

### Error: "mvnw: comando no encontrado"
- Usar: `.\mvnw` (en Windows)
- O: `./mvnw` (en Linux/Mac)

### Error: "No se encuentra la clase Main1"
- Verificar que compiló: `dir target\classes\com\tp3\ejercicio1`
- Recompilar: `.\mvnw clean compile`

### Caracteres especiales en consola
- Algunos símbolos (✓, ✗, →) pueden no mostrarse en consolas antiguas
- No afecta la funcionalidad del programa

## Extensiones Posibles

El diseño permite fácilmente:

1. **Ejercicio 1:** Agregar nuevos tipos de vehículos
2. **Ejercicio 2:** Agregar nuevos planes de suscripción
3. **Ejercicio 3:** Agregar nuevos métodos de pago
4. **Ejercicio 4:** Agregar nuevos dispositivos inteligentes
5. **Ejercicio 5:** Agregar nuevas entidades y hechizos

## Autor
Trabajo Práctico - Programación II  
Universidad Nacional de Santiago del Estero (UNSTA)
