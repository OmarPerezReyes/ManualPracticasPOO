# Manual de práctica: Herencia simple

La herencia es un claro ejemplo de cómo los humanos nos basamos en conceptos de la naturaleza para resolver problemas de la ingeniería. En la vida real, la herencia es el hecho de ceder atributos o posesiones de una persona a otra; en términos de programación, y en específico de la programación orientada a objetos, la herencia refiere al concepto de que una clase padre hereda a una clase hija sus atributos o funciones.

Además de las funciones y atributos heredados de la clase padre, las clases hijas pueden tener sus propios atributos e incluso definir sus propias funciones. También pueden convertirse en clases padre de otras clases hijas: es el ciclo sin fin.

## Herencia en Java

La herencia en Java implica que una superclase o clase base hereda sus funciones y atributos a una subclase o clase derivada. La palabra reservada que nos permite realizar herencia entre clases es extends.

Cabe mencionar que en Java los constructores de las clases no se heredan; sin embargo, pueden ejecutarse en la clase hija con el método super().

Considera que las funciones o atributos del tipo private no podrán heredarse.

## Herencia simple o única
Una clase hija hereda de una clase padre. 

![image](https://github.com/Daniela-Mallozzi/Manual-de-practica-herencia-simple/assets/92596638/0af36707-762d-4ad8-9f78-85c2998d1858)



## Descripción
En esta práctica se seguirán una serie de pasos con el fin de explicar como es que funciona la herencia simple, mecanismo por el cual una clase permite heredar las características (atributos y métodos) de otra clase.


## Paso 1:
Crear una super clase ´Datos´ con funcionamiento de almacenar datos personales de una persona cualquiera. Eesta será nuestra clase padre, la cual heredará después sus atributos y métodos a la clase hija.

<pre><code>public class Datos {
  }
</code></pre>



## Paso 2:
Declarar los atributos que tendrá nuestra clase ´Datos´
Los datos de una persona cualquiera son: nombre, apellido y edad.

<pre><code>public class Datos {
  
    // Atributos
        private String nombre;
        private String apellidos;
        private int edad;

</code></pre>



## Paso 3:
Crear nuestro constructor para inicializar el objeto y establecer sus propiedades y valores predeterminados. 
Tiene el mismo nombre que la clase y no cuenta con ningún valor de retorno, ya que su función principal es inicializar el objeto y no devolver ningún valor.

<pre><code> //Constructor
        public Datos (String nombre, String apellidos, int edad) {

            this.nombre = nombre;

            this.apellidos = apellidos;

            this.edad = edad;   
</code></pre>


## Paso 4:
Crear los métodos que retornarán los atributos (datos de la persona)
<pre><code> //Métodos
        public String getNombre () { return nombre;  }
        public String getApellidos () { return apellidos;  }
        public int getEdad () { return edad;   }

  } //Cierre de la clase Alumno
</code></pre>



## Paso 5:
Crear una clase hija llamada ´Profesor´ la cual **extienda** (*extends*) de la clase padre ´Datos´ para así poder heredar y hacer uso de los atributos y métodos antes creados en la clase padre.
<pre><code> public class Profesor extends Datos{
  }
</code></pre>




## Paso 6:
Declararemos un atributo exclusivo de la subclase o clase hija, solo esta le pertenece a si misma.
La cual será el ID o matrícula de un profesor.

<pre><code>
        //Atributos específicos de la subclase.
        private String IdProfesor;

</code></pre>




## Paso 7:
Crear nuestro constructor para inicializar el objeto y establecer sus propiedades y valores predeterminados. 
Tiene el mismo nombre que la clase y no cuenta con ningún valor de retorno, ya que su función principal es inicializar el objeto y no devolver ningún valor.

Aquí se incluirán los atributos de la clase padre como parámetro del constructor de la clase hija.

<pre><code> 
        //Constructor de la subclase: incluimos como parámetros los del constructor de la superclase (Datos)

        public Profesor (String nombre, String apellidos, int edad) {

            super(nombre, apellidos, edad);
            IdProfesor = "Desconocido";   } //Cierre del constructor


</code></pre>



## Paso 8:
Crear los métodos que retornarán los atributos (datos del profesor)
<pre><code> 
        //Métodos específicos de la subclase
        public void setIdProfesor (String IdProfesor) { this.IdProfesor = IdProfesor;   }
        public String getIdProfesor () { return IdProfesor;   }
        public void mostrarNombreApellidosID() {

         System.out.println ("Nombre del profesor: " + getNombre() + " " +  getApellidos() +

                "\n con Id de profesor: " + getIdProfesor() ); }


} //Cierre de la clase
</code></pre>


## Paso 9:
Para probar nuestro código creamos una clase donde lo ejecutaremos **HerenciaTest**.

<pre><code> 
  
public class HerenciaTest {
        public static void main (String[] Args) {

// INSTANCIA
            Profesor profesor1 = new Profesor ("Refugio", "Hernández García", 48);

</code></pre>

Se hace una instancia de la clase Profesor y se declaran los valores que tendrán los atributos(nombre, apellido y edad) entre paréntesis.

Las instancias son la materialización de una clase, es decir, son objetos concretos que tienen su propio estado (los valores de sus atributos) y su propio comportamiento (los métodos que pueden ejecutar).



## Paso 10:
Determinamos el valor que le daremos al ID del profesor, con la instancia ya realizada anteriormente y el método **SetIdProfesor**.
<pre><code> 
              profesor1.setIdProfesor("2130056");

</code></pre>



## Paso 11:
Ejecutamos la instancia a través del método **mostrarNombreApellidosID()**
<pre><code> 
            profesor1.mostrarNombreApellidosID();}

} //Cierre de la clase HerenciaTest

</code></pre>


## Paso 12:
Probar el código desde **HerenciaTest**.

En la terminal nos saldrán los datos que habíamos establecido desde la clase hija, usando los parámetros de la clase padre.


<img width="650" alt="Captura de pantalla 2023-08-21 221415" src="https://github.com/Daniela-Mallozzi/Manual-de-practica-herencia-simple/assets/92596638/682e34c6-fd61-43bd-95a9-5b8fbc850630">

