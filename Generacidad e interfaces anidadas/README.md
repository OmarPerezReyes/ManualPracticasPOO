# Desarrollo de un Sistema de Gestión de Figuras Geométricas en Java

Utilizar interfaces anidadas y generacidad en Java desarrollando un sistema de gestión de figuras geométricas. Organizar jerarquías de clases relacionadas y aplicar la generacidad para crear código flexible y reutilizable

## Se espera:

- Comprender y aplicar interfaces anidadas para organizar jerarquías de clases relacionadas.
- Aprender a utilizar la generacidad para trabajar con diferentes tipos de figuras geométricas de manera flexible.

## 1. Definición de la Interfaz Figura y Clases Anidadas

### 1.1 Creación de la Interfaz Figura

Se iniciza creando una interfaz llamada `Figura`. Esta interfaz contendrá los métodos para calcular el área y el perímetro de una figura geométrica. Las interfaces anidadas permiten agrupar clases relacionadas dentro de una interfaz.

```java
interface Figura {
    double calcularArea();
    double calcularPerimetro();
}
```

### 1.2 Creación de la Clase Anidada Circulo

Dentro de la interfaz Figura, se ha de crear una clase anidada Circulo para representar un círculo.

```java
interface Figura {
    double calcularArea();
    double calcularPerimetro();

    class Circulo implements Figura {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }

        @Override
        public double calcularPerimetro() {
            return 2 * Math.PI * radio;
        }
    }
}
```

### 1.3 Creación de la Clase Anidada Rectangulo

Se ha de agregar otra clase anidada Rectangulo dentro de la interfaz Figura para representar un rectángulo.

```java
interface Figura {
    double calcularArea();
    double calcularPerimetro();

    class Circulo implements Figura {
        // Implementación del círculo
    }

    class Rectangulo implements Figura {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return base * altura;
        }

        @Override
        public double calcularPerimetro() {
            return 2 * (base + altura);
        }
    }
}
```

## 2. Implementación de una Clase para Gestionar Figuras
### 2.1 Creación de la Clase GestorFiguras
Esta clase debe permitir  gestionar y operar con figuras geométricas de manera genérica.

```java
import java.util.ArrayList;
import java.util.List;

public class GestorFiguras<T extends Figura> {
    private List<T> figuras;

    public GestorFiguras() {
        figuras = new ArrayList<>();
    }

    public void agregarFigura(T figura) {
        figuras.add(figura);
    }

    public void mostrarInfoTodasFiguras() {
        for (T figura : figuras) {
            System.out.println("Tipo de figura: " + figura.getClass().getSimpleName());
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            System.out.println("----------------------");
        }
    }

    public double calcularAreaTotal() {
        double areaTotal = 0;
        for (T figura : figuras) {
            areaTotal += figura.calcularArea();
        }
        return areaTotal;
    }
}
```

Nota:

- La clase GestorFiguras es una clase genérica que trabaja con cualquier tipo de figura que implemente la interfaz Figura.
- Los métodos agregarFigura, mostrarInfoTodasFiguras y calcularAreaTotal permiten manejar y operar con las figuras almacenadas en el gestor.

### 2.2 Utilización de la Generacidad
La generacidad se aplica en la definición de la clase GestorFiguras, donde se utiliza el parámetro de tipo <T extends Figura> para indicar que la clase trabajará con objetos que sean subtipos de la interfaz Figura. Esto nos permite trabajar con diferentes tipos de figuras de manera flexible y reutilizable.

## 3. Prueba del Sistema
### 3.1 Creación del Método Main
Se crea un método main para probar nuestro sistema de gestión de figuras geométricas.

```java
public class Main {
    public static void main(String[] args) {
        // Crear el gestor de figuras
        GestorFiguras<Figura> gestor = new GestorFiguras<>();

        // Crear instancias de figuras
        Figura.Circulo circulo = new Figura.Circulo(5.0);
        Figura.Rectangulo rectangulo = new Figura.Rectangulo(4.0, 3.0);

        // Agregar figuras al gestor
        gestor.agregarFigura(circulo);
        gestor.agregarFigura(rectangulo);

        // Mostrar información de todas las figuras
        System.out.println("Información de todas las figuras:");
        gestor.mostrarInfoTodasFiguras();

        // Calcular el área total de todas las figuras
        double areaTotal = gestor.calcularAreaTotal();
        System.out.println("Área total de todas las figuras: " + areaTotal);
    }
}
```
Nota:
- En el método main, se crea una instancia de GestorFiguras que trabajará con figuras de tipo Figura.
- Se crean instancias de círculo y rectángulo.
- Se agregan las figuras al gestor.
- Se usan  los métodos mostrarInfoTodasFiguras y calcularAreaTotal para mostrar información y calcular el área total de las figuras.
