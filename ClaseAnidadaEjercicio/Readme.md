# Clases Aniadas

1- Crea un código en Java que defina una clase Universidad que contiene una clase anidada llamada Estudiante. Crea instancias de ambas clases y las utiliza para simular estudiantes y sus cursos en una universidad.
Definición de la clase Universidad (Universidad class):
Esta clase representa una universidad y contiene una lista de estudiantes.

2- Constructor de la clase Universidad (public Universidad(String nombre) { ... }):
Este constructor crea una instancia de la universidad y asigna un nombre a la misma. Además, inicializa la lista de estudiantes como un ArrayList.

3- Método agregarEstudiante (public void agregarEstudiante(String nombre, int edad) { ... }):
Este método permite agregar un estudiante a la lista de estudiantes de la universidad. Recibe el nombre y la edad del estudiante, crea una instancia de la clase Estudiante y la agrega a la lista de estudiantes de la universidad.

4- El Método mostrarInformacionEstudiantes (public void mostrarInformacionEstudiantes() { ... }):
Este método muestra la información de todos los estudiantes de la universidad. Itera a través de la lista de estudiantes y muestra el nombre, la edad y los cursos de cada estudiante.

5- La definición de la clase anidada Estudiante (Estudiante nested class):
Esta clase representa a un estudiante de la universidad y contiene su nombre, edad y lista de cursos.

6- El constructor de la clase Estudiante (public Estudiante(String nombre, int edad) { ... }):
Este constructor crea una instancia de un estudiante con un nombre y una edad especificados. Además, inicializa la lista de cursos como un ArrayList.

7- El método agregarCurso (public void agregarCurso(String curso) { ... }):
Este método permite agregar un curso al estudiante. Recibe el nombre del curso y lo agrega a la lista de cursos del estudiante.

8- El método getCursos (public List<String> getCursos() { ... }):
Este método devuelve la lista de cursos del estudiante.

9- La clase principal EjemploClaseAnidada (EjemploClaseAnidada class):
La clase principal contiene el método main que crea una instancia de la clase Universidad, luego crea dos instancias de la clase Estudiante y agrega cursos a cada estudiante. Finalmente, agrega los estudiantes a la lista de la universidad y muestra la información de todos los estudiantes.
