package org.example;

import ConsultorMonedas.BuscarMonedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BuscarMonedas buscarMonedas = new BuscarMonedas();

        while (true){
            System.out.println("Sea bienvenido al conversor de monedas\n" +
                    "1. Dólar => Peso Argentino\n" +
                    "2. Peso Argentino => Dólar\n" +
                    "3. Dólar => Real Brasileño\n" +
                    "4. Real Brasileño => Dólar\n" +
                    "5. Dólar => Peso Colombiano\n" +
                    "6. Peso Colombiano => Dólar\n"+
                    "7. Salir\n" +
                    "Elija una opción válida");

            Scanner ingreso = new Scanner(System.in);
            int respuesta = ingreso.nextInt();
            if (respuesta == 7){
                System.out.println("Hasta pronto");
                break;
            }else {
                if (respuesta >= 1 && respuesta < 7) {
                    System.out.println("Ingrese un monto:");
                    Scanner montoIngresado = new Scanner(System.in);
                    int monto = montoIngresado.nextInt();
                    buscarMonedas.CambioMoneda(respuesta, monto);
                }else {
                    System.out.println("Ingrese una opcion valida");
                }
            }
        }
    }

}
