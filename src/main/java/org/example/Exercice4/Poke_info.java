package org.example.Exercice4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Poke_info {

    public static void getPokemonInfo(String pokemonName) throws IOException, InterruptedException {
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONObject json = new JSONObject(response.body());

            String name = json.getString("name");
            int weight = json.getInt("weight");
            int height = json.getInt("height");

            System.out.println("Informations sur le Pokémon : " + name + ", poids : " + weight + " kg, taille : " + height + " cm");

        } else if (response.statusCode() == 404) {
            System.out.println("Ce pokémon n'existe pas : " + pokemonName);
        } else {
            System.out.println("Erreur inattendue, code HTTP : " + response.statusCode());
        }
    }
}
