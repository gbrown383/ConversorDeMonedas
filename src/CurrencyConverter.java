package com.conversor;

import org.json.JSONObject;

import java.util.Scanner;

public class CurrencyConverter {
    private final ApiService apiService = new ApiService();
    private final Scanner scanner = new Scanner(System.in);

    public void convertir(String base, String destino) {
        try {
            System.out.print("\nIngrese el valor que deseas convertir: ");
            double monto = Double.parseDouble(scanner.nextLine());

            JSONObject data = apiService.getRates(base);
            double tasa = data.getJSONObject("conversion_rates").getDouble(destino);
            double convertido = monto * tasa;

            System.out.printf(
                    "\nEl valor %.2f [%s] corresponde al valor final de =>>>> %.2f [%s]\n\n",
                    monto, base, convertido, destino
            );

        } catch (Exception e) {
            System.out.println("❌ Error en la conversión: " + e.getMessage());
        }
    }

    public void mostrarMonedasDisponibles() {
        try {
            JSONObject data = apiService.getRates("USD");
            JSONObject rates = data.getJSONObject("conversion_rates");
            System.out.println("\n📌 Monedas disponibles:");
            for (String key : rates.keySet()) {
                System.out.print(key + " ");
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("❌ No se pudo cargar la lista de monedas.");
        }
    }
}
