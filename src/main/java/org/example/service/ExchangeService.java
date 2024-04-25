package org.example.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {
    private static final String SERVICE_URL = "https://v6.exchangerate-api.com/v6/e5ee792736350a2fb9825ef1/latest/USD";

    public String requestExchange() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(SERVICE_URL)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                return response.body();
            }

        } catch (IOException | InterruptedException e) {
            //TODO: LOG
            e.printStackTrace();
        }
        return null;
    }

    public double convertToCoin(double valorAConvertir, double valorMoneda) {
        return valorAConvertir * valorMoneda;
    }

    public double convertirADolar(double valorAConvertir, double valorMoneda) {
        return valorAConvertir/valorMoneda;
    }
}
