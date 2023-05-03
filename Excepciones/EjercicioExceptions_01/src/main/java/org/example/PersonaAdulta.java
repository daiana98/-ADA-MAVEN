package org.example;

public class PersonaAdulta {
    private String nombre;
    private int edad;


    //primer constructor que tire excepcion
    public PersonaAdulta(String nombre, int edad) throws Exception{
        this.nombre = nombre;

        if (edad < 18)
            throw new Exception("No es adulta la persona " + nombre + " por que tiene " + edad + " años");
        this.edad = edad;
    }

    public void fijarEdad(int edad) throws Exception{
        if(edad < 18)
            throw new Exception("No es adulta la persona " + nombre + " por que tiene " + edad + " años");
        this.edad=edad;
    }

    public void imprimir(){
        System.out.println(nombre + " - " + edad);
    }

}
