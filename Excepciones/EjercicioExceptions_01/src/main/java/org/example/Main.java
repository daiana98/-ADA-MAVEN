package org.example;

public class Main {
    public static void main(String[] args) {

        try {

            PersonaAdulta persona1 = new PersonaAdulta("Daiana",24);
            persona1.imprimir();

            PersonaAdulta persona2 = new PersonaAdulta("Marcos",4);
            persona2.imprimir();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("fin del programa");
        }
    }
}