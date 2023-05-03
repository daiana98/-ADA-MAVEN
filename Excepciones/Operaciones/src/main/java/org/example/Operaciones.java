package org.example;

public class Operaciones {
    private int valor1;
    private int valor2;

    public Operaciones(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public void sumar(){
        int suma = valor1 + valor2;
        System.out.println("El resultado de la suma es: " + suma);

    }

    public void resta(){
        int resta = valor1 - valor2;
        System.out.println("El resultado de la resta es: " + resta);
    }

    public void multiplicar(){
        int producto = valor1 * valor2;
        System.out.println("El producto es: " + producto);

    }

    public void dividir() throws Exception{
        if (valor2 == 0)
            throw new Exception("No se puede dividir por cero");
        int division = valor1 / valor2;

        System.out.println("La division es: " + division);
    }
}
