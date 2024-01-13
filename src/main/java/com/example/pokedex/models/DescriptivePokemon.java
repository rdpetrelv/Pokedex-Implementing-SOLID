package com.example.pokedex.models;

public class DescriptivePokemon extends Pokemon{
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description;

    public DescriptivePokemon(int pokemonid, String pokemonName, int weigth, int heigth) {
        super(pokemonid, pokemonName, weigth, heigth);
    }

    public DescriptivePokemon() {
    }
}
