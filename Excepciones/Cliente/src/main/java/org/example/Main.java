package org.example;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Daiana", 10000);
        cliente1.imprimir();
        cliente1.depositar(2000);
        cliente1.imprimir();

        try {

            cliente1.extraer(5000);
            cliente1.imprimir();
            cliente1.extraer(70000);
            cliente1.imprimir();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}