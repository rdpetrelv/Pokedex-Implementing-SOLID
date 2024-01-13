package com.example.pokedex.services;

import java.util.ArrayList;
import java.util.List;

public interface DataExtractionInterface {

    public List<String> pokemonArgs = new ArrayList<>();

    public List<String> getPokemonFromSource(int id);

}
