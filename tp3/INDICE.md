# Índice del Proyecto TP3

## 📋 Documentación

1. **README.md** - Documentación técnica completa
   - Descripción de cada ejercicio
   - Estructura de clases
   - Conceptos aplicados
   - Instrucciones de compilación y ejecución

2. **INFORME.md** - Informe detallado del trabajo
   - Análisis profundo de cada ejercicio
   - Problemas encontrados y soluciones
   - Conclusiones y lecciones aprendidas
   - Patrones de diseño
   - Requisitos cumplidos

3. **HELP.md** - Guía rápida
   - Estructura del proyecto
   - Cómo compilar
   - Cómo ejecutar
   - Troubleshooting

4. **RESUMEN.txt** - Resumen ejecutivo
   - Estado del trabajo
   - Ejercicios completados
   - Estructura del proyecto
   - Instrucciones de compilación

---

## 🗂️ Estructura del Código

### Ejercicio 1: Sistema de Flota de Transporte (4 clases)
```
ejercicio1/
├── Vehiculo.java          (clase abstracta)
├── Furgoneta.java         (extends Vehiculo)
├── Motocicleta.java       (extends Vehiculo)
└── Main1.java             (programa principal)
```

### Ejercicio 2: Gestor de Suscripciones (5 clases)
```
ejercicio2/
├── Suscripcion.java       (clase abstracta)
├── PlanBasico.java        (extends Suscripcion)
├── PlanFamiliar.java      (extends Suscripcion)
├── PlanPremium.java       (extends Suscripcion)
└── Main2.java             (programa principal)
```

### Ejercicio 3: Pasarela de Pagos (5 clases)
```
ejercicio3/
├── PasarelaPago.java      (interfaz)
├── TarjetaCredito.java    (implements PasarelaPago)
├── PayPal.java            (implements PasarelaPago)
├── Criptomonedas.java     (implements PasarelaPago)
└── Main3.java             (programa principal)
```

### Ejercicio 4: Dispositivos Inteligentes (6 clases)
```
ejercicio4/
├── TomarFoto.java              (interfaz)
├── ConectarWiFi.java           (interfaz)
├── CamaraSeguridad.java        (implements TomarFoto)
├── TermostroInteligente.java   (implements ConectarWiFi)
├── Smartphone.java             (implements ambas)
└── Main4.java                  (programa principal)
```

### Ejercicio 5: Videojuego de Rol (10 clases)
```
ejercicio5/
├── EntidadEspacial.java        (abstracta)
├── SerVivo.java                (abstracta, extends EntidadEspacial)
├── LanzarHechizos.java         (interfaz)
├── Personaje.java              (abstracta, extends SerVivo)
├── GuerreroHumano.java         (extends Personaje)
├── MagoElfo.java               (extends Personaje, implements LanzarHechizos)
├── Monstruo.java               (abstracta, extends SerVivo)
├── Orco.java                   (extends Monstruo)
├── Dragon.java                 (extends Monstruo, implements LanzarHechizos)
└── Main5.java                  (programa principal)
```

---

## 🚀 Ejecución Rápida

```bash
# Compilar todo
cd tp3
.\mvnw clean compile

# Ejecutar cada ejercicio
java -cp target\classes com.tp3.ejercicio1.Main1
java -cp target\classes com.tp3.ejercicio2.Main2
java -cp target\classes com.tp3.ejercicio3.Main3
java -cp target\classes com.tp3.ejercicio4.Main4
java -cp target\classes com.tp3.ejercicio5.Main5
```

---

## ✅ Estadísticas del Proyecto

| Métrica | Cantidad |
|---------|----------|
| Archivos Java | 30 |
| Clases Abstractas | 5 |
| Interfaces | 4 |
| Clases Concretas | 21 |
| Métodos Main | 5 |
| Líneas de Código | ~1500 |
| Archivos de Documentación | 4 |

---

## 📚 Conceptos por Ejercicio

| Ejercicio | Herencia | Abstracta | Interfaz | Polimorfismo |
|-----------|----------|-----------|----------|--------------|
| 1. Flota | ✅ | ✅ | ❌ | ✅ |
| 2. Streaming | ✅ | ✅ | ❌ | ✅ |
| 3. E-commerce | ❌ | ❌ | ✅ | ✅ |
| 4. Dispositivos | ❌ | ❌ | ✅ | ✅ |
| 5. Videojuego | ✅ | ✅ | ✅ | ✅ |

---

## 🎯 Requisitos Cumplidos

- ✅ Aplicación de Herencia
- ✅ Diseño de Clases Abstractas
- ✅ Implementación de Interfaces
- ✅ Resolución de Herencia Múltiple
- ✅ Aplicación de Polimorfismo
- ✅ Compilación sin errores
- ✅ Ejecución verificada
- ✅ Documentación completa

---

## 📖 Lectura Recomendada

Para comprender mejor el código:

1. Comenzar con **HELP.md** para visión general
2. Leer **README.md** para detalles técnicos
3. Revisar **INFORME.md** para análisis profundo
4. Ejecutar los programas para ver resultados

---

## 🔍 Cómo Usar Este Proyecto

### Para Aprender
1. Leer la documentación en README.md
2. Estudiar el código de cada ejercicio
3. Ejecutar los programas y analizar la salida
4. Modificar el código para experimentar

### Para Presentar
1. Mostrar la compilación exitosa
2. Ejecutar cada ejercicio demostrando salida
3. Presentar la documentación INFORME.md
4. Explicar los conceptos aplicados

### Para Extender
1. El diseño permite agregar fácilmente:
   - Nuevos vehículos (Ejercicio 1)
   - Nuevos planes (Ejercicio 2)
   - Nuevas pasarelas de pago (Ejercicio 3)
   - Nuevos dispositivos (Ejercicio 4)
   - Nuevas entidades del juego (Ejercicio 5)

---

## 📝 Notas Importantes

- Requiere Java 21 o superior
- Maven se incluye como Maven Wrapper
- Primera compilación descarga dependencias (~2 min)
- Todos los ejercicios compilan y ejecutan sin errores
- Algunos caracteres especiales pueden no aparecer en consolas antiguas

---

**Proyecto Completado:** 3 de mayo de 2026  
**Estado:** ✅ Listo para Entrega  
**Alumno:** Emiliano Medina  
**Profesor:** Ing. Tulio Ruesjas Martín
