package org.example.amiibo_api;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public static startingAPI callAPI(String gameSeries) throws IOException, InterruptedException {
        //Handling possible spaces
        gameSeries = gameSeries.replaceAll(" ", "%20");

        String uri = "https://www.amiiboapi.com/api/amiibo/?type=Figure&gameseries="+gameSeries;

        //configure the environment to make a HTTP request (this includes an update to the
        //module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        /* this will save a file called Amiibos.json with the APIs response
        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
        .ofFile(Paths.get("Amiibos.json"))); */

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                .ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), startingAPI.class);
    }

}
