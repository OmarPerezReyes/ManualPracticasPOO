// 1. Definición de la Interfaz Figura y Clases Anidadas

// Definición de la interfaz Figura
interface Figura {
    // Método para calcular el área de la figura
    // Método para calcular el perímetro de la figura

    // Clase anidada Circulo que implementa la interfaz Figura
    class Circulo implements Figura {
        // Radio del círculo

        // Constructor de la clase Circulo
        public Circulo(double radio) {
            // Inicialización del radio
        }

        // Implementación del método calcularArea para el círculo
        @Override
        public double calcularArea() {
            return Math.PI * radio * radio; // Fórmula del área del círculo
        }

        // Implementación del método calcularPerimetro para el círculo
        @Override
        public double calcularPerimetro() {
            return 2 * Math.PI * radio; // Fórmula del perímetro del círculo
        }
    }

    // Clase anidada Rectangulo que implementa la interfaz Figura
    class Rectangulo implements Figura {
        // Base del rectángulo
        // Altura del rectángulo

        // Constructor de la clase Rectangulo
        public Rectangulo(double base, double altura) {
            // Inicialización de la base
            // Inicialización de la altura
        }

        // Implementación del método calcularArea para el rectángulo
        @Override
        public double calcularArea() {
            return base * altura; // Fórmula del área del rectángulo
        }

        // Implementación del método calcularPerimetro para el rectángulo
        @Override
        public double calcularPerimetro() {
            return 2 * (base + altura); // Fórmula del perímetro del rectángulo
        }
    }
}
