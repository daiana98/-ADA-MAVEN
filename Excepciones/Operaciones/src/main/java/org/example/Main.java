package org.example;

public class Main {
    public static void main(String[] args) {
        Operaciones op1 = new Operaciones(10,2);
        op1.sumar();
        op1.resta();
        op1.multiplicar();

        try {

            op1.dividir();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}