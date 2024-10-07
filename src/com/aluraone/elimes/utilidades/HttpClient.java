package com.aluraone.elimes.utilidades;

import com.aluraone.elimes.modelos.CambioApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();


    public CambioApi buscarCambio(String codigoBase, String codigoConversion) {
        String direccion = "https://v6.exchangerate-api.com/v6/be3c0b85dab6aac84562d7f7/pair/" + codigoBase + "/" + codigoConversion;

        //Usando HTTP Request
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            //Recibiendo respuesta
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Creando una clase PeliculaOmdb donde se pasará el JSON a la claseOMDB
            return gson.fromJson(response.body(), CambioApi.class);
        } catch (Exception e) {
            throw new RuntimeException("Error de códigos de monedas");
        }
    }
}
