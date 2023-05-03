package org.example;

import Servicio.AnimalServicio;

public class Main {
    public static void main(String[] args) {
        AnimalServicio animalServicio = new AnimalServicio();

        try {

            animalServicio.imprimirLista();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}