package org.example;

import com.google.gson.Gson;
import org.example.model.ExchangeResponse;
import org.example.service.ExchangeService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ExchangeService service = new ExchangeService();
        String resp = service.requestExchange();
        Gson gs = new Gson();
        ExchangeResponse exchangeResponse = gs.fromJson(resp, ExchangeResponse.class);

        int opcion = 0;

        double valorUSD = exchangeResponse.getConversion_rates().getUSD();
        double valorPesoArg = exchangeResponse.getConversion_rates().getARS();
        double valorRealBrasilero = exchangeResponse.getConversion_rates().getBRL();
        double valorPesoColombiano = exchangeResponse.getConversion_rates().getCOP();

        StringBuilder sb = new StringBuilder("*** CONVERTIDOR DE MONEDAS ***");
        sb.append("\n")
        .append("USD : ").append(valorUSD)
        .append("\n")
        .append("ARS : ").append(valorPesoArg)
        .append("\n")
        .append("BRL : ").append(valorRealBrasilero)
        .append("\n")
        .append("COP : ").append(valorPesoColombiano);

        System.out.println(sb.toString());

        String menu = """
                
                SELECCIONE UNA OPCION: 
                          
                1 - Dolar =>> Peso Argentino
                2 - Peso Argentino =>> Dolar
                3 - Dolar =>> Real brasilero
                4 - Real brasilero =>> Dolar
                5 - Dolar =>> Peso colombiano
                6 - Peso colombiano =>> Dolar 
                7 - Salir
                Elija una opcion valida
                *******************************************************
                """;
        Scanner teclado = new Scanner(System.in);


        while (opcion != 7){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valorAConvertir = teclado.nextDouble();
                    double resultado = service.convertToCoin(valorAConvertir, valorPesoArg);
                    System.out.println("El valor " + valorAConvertir + "[USD] corresponde al valor final de =>> " +resultado + " [ARS]");
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valorAConvertir2 = teclado.nextDouble();
                    double resultado2 = valorAConvertir2/valorPesoArg;
                    System.out.println("El valor " + valorAConvertir2 + "[ARS] corresponde al valor final de =>> " +resultado2 + " [USD]");
                    break;
                case 3:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valorAConvertir3 = teclado.nextDouble();
                    double resultado3 = valorAConvertir3 * valorRealBrasilero;
                    System.out.println("El valor " + valorAConvertir3 + "[USD] corresponde al valor final de =>> " +resultado3 + " [BRL]");
                    break;
                case 4:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valorAConvertir4 = teclado.nextDouble();
                    double resultado4 = valorAConvertir4/valorRealBrasilero;
                    System.out.println("El valor " + valorAConvertir4 + "[BRL] corresponde al valor final de =>> " +resultado4 + " [USD]");
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valorAConvertir5 = teclado.nextDouble();
                    double resultado5 = valorPesoColombiano * valorAConvertir5;

                    System.out.println("El valor " + valorAConvertir5 + "[USD] corresponde al valor final de =>> " +resultado5 + " [COP]");
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valorAConvertir6 = teclado.nextDouble();
                    double resultado6 = valorAConvertir6/valorPesoColombiano;
                    System.out.println("El valor " + valorAConvertir6 + "[COP] corresponde al valor final de =>> " + resultado6 + " [USD]");
                    break;
                case 7:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }

    }
}