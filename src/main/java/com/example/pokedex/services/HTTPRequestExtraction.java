package com.example.pokedex.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class HTTPRequestExtraction implements DataExtractionInterface{

    String baseApiUrl = "https://pokeapi.co/api/v2/pokemon/";

    @Override
    public List<String> getPokemonFromSource(int id) {
        String jsonResponse = "";
        baseApiUrl = baseApiUrl + String.valueOf(id);
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            //HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/1");
            HttpGet request = new HttpGet(baseApiUrl);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;

                //Here update the parameters

                //set id
                pokemonArgs.add(obj.get("id").toString());
                //set name
                pokemonArgs.add(obj.get("name").toString());
                //set height
                pokemonArgs.add(obj.get("height").toString());
                //set weight
                pokemonArgs.add(obj.get("weight").toString());

            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }




        return pokemonArgs;
    }
}
