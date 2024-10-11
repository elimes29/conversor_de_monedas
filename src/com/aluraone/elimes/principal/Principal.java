package com.aluraone.elimes.principal;

import com.aluraone.elimes.modelos.Cambio;
import com.aluraone.elimes.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Utilidades calculaCambio = new Utilidades();

        // Varialbles globales
        int seleccion = 0;
        List<Cambio> cambiosConsultados = new ArrayList<>();

        //Menú inicial
        System.out.println("**************************************");
        System.out.println("Bienvenido al conversor de Monedas");
        System.out.println("**************************************");
        System.out.println();

        while (seleccion != 7) {
            Cambio cambio = new Cambio();

            //Menú repetitivo
            System.out.println("Ingrese el número correspondiente a la opción que deseas elegir:");
            System.out.println("1) Dolar ==> Peso Argentino");
            System.out.println("2) Peso Argentino ==> Dolar");
            System.out.println("3) Dolar ==> Real Brasileño");
            System.out.println("4) Real Brasileño ==> Dolar");
            System.out.println("5) Dolar ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> Dolar");
            System.out.println("7) Salir");

            try {
                // Leemos el número de la selección
                seleccion = scanner.nextInt();

                // Analizando que esté entre 1 y 7
                if (seleccion >= 1 && seleccion <= 6) {


                    //Hacemos la conversión y mostramos el resultado
                    switch (seleccion){
                        case 1:
                            //1) Dolar ==> Peso Argentino
                            cambio = calculaCambio.mustraResultado("USD","ARS");
                            cambiosConsultados.add(cambio);
                            break;
                        case 2:
                            //2) Peso Argentino ==> Dolar
                            cambio = calculaCambio.mustraResultado("ARS","USD");
                            cambiosConsultados.add(cambio);
                            break;
                        case 3:
                            //3) Dolar ==> Real Brasileño
                            cambio = calculaCambio.mustraResultado("USD","BRL");
                            cambiosConsultados.add(cambio);
                            break;
                        case 4:
                            //4) Real Brasileño ==> Dolar
                            cambio = calculaCambio.mustraResultado("BRL","USD");
                            cambiosConsultados.add(cambio);
                            break;
                        case 5:
                            //5) Dolar ==> Peso Colombiano
                            cambio = calculaCambio.mustraResultado("USD","COP");
                            cambiosConsultados.add(cambio);
                            break;
                        case 6:
                            //6) Peso Colombiano ==> Dolar
                            cambio = calculaCambio.mustraResultado("COP","USD");
                            cambiosConsultados.add(cambio);
                            break;
                    }
                    //Imprimimos el historial de consultas
                    System.out.println("**************************************");
                    System.out.println("Historial de consultas");
                    for (Cambio consulta : cambiosConsultados){
                        System.out.println(consulta.toString());
                    }
                    System.out.println("**************************************");
                    System.out.println();
                } else if (seleccion == 7) {
                    //Salimos del programa
                    System.out.println("**************************************");
                    System.out.println("Seleccionaste Salir. Gracias por usar la calculadora");
                    System.out.println("**************************************");
                    System.out.println();
                } else {
                    //Retornamos al loop
                    System.out.println("Ingresaste " + seleccion + " y este no está entre las opciones." +
                            " Vuelve a intentarlo.");
                    System.out.println("**************************************");
                    System.out.println();
                    seleccion = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número adecuado al menú.");
                System.out.println("**************************************");
                System.out.println();
                scanner.next(); // Limpia el buffer de entrada
                seleccion = 0;  // Reinicia la selección
            }
        }
    }
}
