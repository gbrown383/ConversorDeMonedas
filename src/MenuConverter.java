package com.conversor;

import java.util.Scanner;

public class MenuConverter {
    private final CurrencyConverter converter = new CurrencyConverter();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("****************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println();
            System.out.println("1) Dólar => Peso Mexicano");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Dolar => Quetzal Guatemalteco");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Mostrar monedas disponibles");
            System.out.println("8) Salir");
            System.out.print("\nElija una opción válida: ");
            System.out.println("****************************************");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> converter.convertir("USD", "MXN");
                case 2 -> converter.convertir("ARS", "USD");
                case 3 -> converter.convertir("USD", "BRL");
                case 4 -> converter.convertir("USD", "GTQ");
                case 5 -> converter.convertir("USD", "COP");
                case 6 -> converter.convertir("COP", "USD");
                case 7 -> converter.mostrarMonedasDisponibles();
                case 8 -> System.out.println("Gracias por usar el conversor 😊");
                default -> System.out.println(" Opción inválida.");
            }

        } while (opcion != 8);
    }
}
