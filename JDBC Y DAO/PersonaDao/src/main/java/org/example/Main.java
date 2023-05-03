package org.example;

import Service.PersonaServicio;

public class Main {
    public static void main(String[] args) {

        PersonaServicio personaServicio = new PersonaServicio();

        try {

            personaServicio.imprimirPersonas();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}