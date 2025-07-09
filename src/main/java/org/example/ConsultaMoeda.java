package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

    public Moeda buscaValorDaMoeda(String moedaBase, String moedaAlvo, double valorParaConversao) {
        String apiKey = "7d1b3fcd0b86cbccf596968a"; // Sua chave de API gerada em https://www.exchangerate-api.com
        URI apiUri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaBase + "/" + moedaAlvo + "/" + valorParaConversao);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUri)
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            if (responseBody.contains("\"result\":\"error\"")) {
                ErroExchangerateApi erro = new Gson().fromJson(responseBody, ErroExchangerateApi.class);
                if ("invalid-key".equals(erro.errorType())) {
                    throw new RuntimeException("Chave de API inválida. Verifique sua chave em https://www.exchangerate-api.com");
                } else {
                    throw new RuntimeException("Erro da API: " + erro.errorType());
                }
            }

            return new Gson().fromJson(responseBody, Moeda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possivel buscar os valores das moedas: " + moedaBase + " -> " + moedaAlvo, e);
        }
    }
}
