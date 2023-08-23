package org.example;

import java.util.ArrayList;
import java.util.List;

// Definición de la clase Universidad
 class Universidad {

    private String nombre;
    private List<Estudiante> estudiantes;

    // Constructor de la clase Universidad
    public Universidad(String nombre) {
        this.nombre = nombre;
        estudiantes = new ArrayList<>();
    }

    // Método para agregar un estudiante a la lista de estudiantes
    public void agregarEstudiante(String nombre, int edad) {
    }

    // Método para mostrar la información de todos los estudiantes de la universidad
    public void mostrarInformacionEstudiantes() {

    }

    // Definición de la clase anidada Estudiante dentro de la clase Universidad
    class Estudiante {

        private String nombre;
        private int edad;
        private List<String> cursos;

        // Constructor de la clase Estudiante
        public Estudiante(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
            cursos = new ArrayList<>();
        }

        // Método para obtener el nombre del estudiante
        public String getNombre() {
            return nombre;
        }

        // Método para obtener la edad del estudiante
        public int getEdad() {
            return edad;
        }

        // Método para agregar un curso al estudiante
        public void agregarCurso(String curso) {
            cursos.add(curso);
        }

        // Método para obtener la lista de cursos del estudiante
        public List<String> getCursos() {
            return cursos;
        }
    }
}
