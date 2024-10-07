package com.aluraone.elimes.principal;

import com.aluraone.elimes.modelos.CambioApi;
import com.aluraone.elimes.utilidades.CalculaCambio;
import com.aluraone.elimes.utilidades.HttpClient;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HttpClient http = new HttpClient();
        CalculaCambio calculaCambio = new CalculaCambio();

         /*

         Código para probar

        CambioApi cambioApi = http.buscarCambio("USD","ves");

        System.out.println(cambioApi);

        //Preueba convirtiendo 100$ a Bs
        double monedaBase = 100;
        BigDecimal monedaObjetivo = calculaCambio.convierte(monedaBase,cambioApi.conversionRate());
        System.out.println(monedaBase + " $ equivalen a "+ monedaObjetivo + " Bs");
        */




        // Varialbles globales
        int seleccion = 0;
        double valor;
        BigDecimal monedaObjetivo;

        System.out.println("**************************************");
        System.out.println("Bienvenido al conversor de Monedas");
        System.out.println("**************************************");
        System.out.println();

        while (seleccion != 7) {
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
                            valor = calculaCambio.solicitaValor();
                            CambioApi cambioApi1 = http.buscarCambio("USD","ARS");
                            monedaObjetivo = calculaCambio.convierte(valor,cambioApi1.conversionRate());
                            System.out.println("**************************************");
                            System.out.println(valor + " US$ equivalen a "+ monedaObjetivo + " Pesos Argentinos");
                            break;
                        case 2:
                            //2) Peso Argentino ==> Dolar
                            valor = calculaCambio.solicitaValor();
                            CambioApi cambioApi2 = http.buscarCambio("ARS","USD");
                            monedaObjetivo = calculaCambio.convierte(valor,cambioApi2.conversionRate());
                            System.out.println("**************************************");
                            System.out.println(valor + " Pesos Argentinos equivalen a "+ monedaObjetivo + " US$");
                            break;
                        case 3:
                            //3) Dolar ==> Real Brasileño
                            valor = calculaCambio.solicitaValor();
                            CambioApi cambioApi3 = http.buscarCambio("USD","BRL");
                            monedaObjetivo = calculaCambio.convierte(valor,cambioApi3.conversionRate());
                            System.out.println("**************************************");
                            System.out.println(valor + " US$ equivalen a "+ monedaObjetivo + " Reales Brasileños");
                            break;
                        case 4:
                            //4) Real Brasileño ==> Dolar
                            valor = calculaCambio.solicitaValor();
                            CambioApi cambioApi4 = http.buscarCambio("BRL","USD");
                            monedaObjetivo = calculaCambio.convierte(valor,cambioApi4.conversionRate());
                            System.out.println("**************************************");
                            System.out.println(valor + " Reales Brasileños equivalen a "+ monedaObjetivo + " US$");
                            break;
                        case 5:
                            //5) Dolar ==> Peso Colombiano
                            valor = calculaCambio.solicitaValor();
                            CambioApi cambioApi5 = http.buscarCambio("USD","COP");
                            monedaObjetivo = calculaCambio.convierte(valor,cambioApi5.conversionRate());
                            System.out.println("**************************************");
                            System.out.println(valor + " US$ equivalen a "+ monedaObjetivo + " Pesos Colombianos");
                            break;
                        case 6:
                            //6) Peso Colombiano ==> Dolar
                            valor = calculaCambio.solicitaValor();
                            CambioApi cambioApi6 = http.buscarCambio("COP","USD");
                            monedaObjetivo = calculaCambio.convierte(valor,cambioApi6.conversionRate());
                            System.out.println("**************************************");
                            System.out.println(valor + " Pesos Colombianos equivalen a "+ monedaObjetivo + " US$");
                            break;
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
                    System.out.println("Ingresaste " + seleccion + " y este no está entre las opciones. Vuelve a intentarlo.");
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
