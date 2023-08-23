package edu.upvictoria.fpoo;

public class Profesor extends Datos{

    //Atributos específicos de la subclase.
    private String IdProfesor;



    //Constructor de la subclase: incluimos como parámetros los del constructor de la superclase (Datos)

    public Profesor (String nombre, String apellidos, int edad) {

        super(nombre, apellidos, edad);
        IdProfesor = "Desconocido";   } //Cierre del constructor



    //Métodos específicos de la subclase
    public void setIdProfesor (String IdProfesor) { this.IdProfesor = IdProfesor;   }
    public String getIdProfesor () { return IdProfesor;   }
    public void mostrarNombreApellidosID() {

        System.out.println ("\n Nombre del profesor: " + getNombre() + " " +  getApellidos() +

                "\n con Id de profesor: " + getIdProfesor() ); }

} //Cierre de la clase

