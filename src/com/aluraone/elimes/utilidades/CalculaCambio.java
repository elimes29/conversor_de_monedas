package com.aluraone.elimes.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculaCambio {

    Scanner scanner = new Scanner(System.in);

    public BigDecimal convierte(double monedaOrigen, double tasa){
        //Convirtiendo
        double resultado = monedaOrigen * tasa;

        // Convertir el double a BigDecimal
        BigDecimal bd = new BigDecimal(Double.toString(resultado));

        // Redondear a 2 decimales con RoundingMode.HALF_UP
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    public double solicitaValor() {
        double monto = 0.0;  // Definir la variable monto fuera del try-catch

        while (true) {
            try {
                System.out.println("Ingresa el monto que quieres convertir");
                monto = scanner.nextDouble();
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.next();  // Limpia el buffer de entrada
            }
        }
        return monto;  // Retorna el monto una vez que sea un número válido
    }

}
