package com.example.pokedex.models;

public class Pokemon {
    public int pokemonid;
    public String pokemonName;
    public int weigth;
    public int heigth;

    public Pokemon(int pokemonid, String pokemonName, int weigth, int heigth) {
        this.pokemonid = pokemonid;
        this.pokemonName = pokemonName;
        this.weigth = weigth;
        this.heigth = heigth;
    }

    public Pokemon() {
    }

    public void setPokemonid(int pokemonid) {
        this.pokemonid = pokemonid;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getPokemonid() {
        return pokemonid;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getHeigth() {
        return heigth;
    }
}
