package com.example.javaassignment2.Utilities;

import com.example.javaassignment2.Models.ApiResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {
    public static ApiResponse getCountryData(String countryCode) throws IOException, InterruptedException {
        String url = "https://wft-geo-db.p.rapidapi.com/v1/geo/countries/" + countryCode;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "ae07961b66msh2e1bdda07b3dfd8p1ae3f3jsn344158f8f426")
                .header("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), ApiResponse.class);
    }
}
