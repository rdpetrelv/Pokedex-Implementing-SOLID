package com.example.pokedex.controllers;

import com.example.pokedex.models.DescriptivePokemon;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.DataExtractionInterface;

import java.util.List;

public class PokemonController {

    public DataExtractionInterface dataExtractionInterface;
    public DescriptivePokemon pokemon = new DescriptivePokemon();

    public PokemonController() {
    }

    public PokemonController(DataExtractionInterface dataExtractionInterface, DescriptivePokemon pokemon) {
        this.dataExtractionInterface = dataExtractionInterface;
        this.pokemon = pokemon;
    }

    public DescriptivePokemon getPokemon(){
        return this.pokemon;
    }

    public void setPokemon(DescriptivePokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setDataExtractionInterface(DataExtractionInterface dataExtractionInterface) {
        this.dataExtractionInterface = dataExtractionInterface;
    }

    public void setPokemonFromResource(int id){
        List<String> pokemonAttributes = dataExtractionInterface.getPokemonFromSource(id);
        try {
            pokemon.setPokemonid(Integer.parseInt(pokemonAttributes.get(0)));
            pokemon.setPokemonName(pokemonAttributes.get(1));
            pokemon.setWeigth(Integer.parseInt(pokemonAttributes.get(3)));
            pokemon.setHeigth(Integer.parseInt(pokemonAttributes.get(2)));
            if ( pokemonAttributes.size()>4){
                pokemon.setDescription(pokemonAttributes.get(4));
            }
        } catch (Exception e){
            System.out.println("No pokemon retrieved");
        }

    }
}
