package com.example.pokedex.views;

import com.example.pokedex.models.DescriptivePokemon;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.utilities.CsvGenerator;
import com.example.pokedex.utilities.MultipleFormatGenerator;

import javax.sql.DataSource;

public class PokemonView implements MultipleFormatGenerator {
    Boolean descriptionRequired = false;
    DescriptivePokemon pokemon;
    String headersCSV = "Id;Name;Height;Weight;";
    String headerCSVDescription = "Description;";
    String pokemonIdLabelText = "Pokémon # ";
    String pokemonNameLabelText = "Nom : ";
    String pokemonHeightLabelText = "Taille : ";
    String pokemonWeightLabelText = "Poids : ";
    String pokemonDescriptionLabelText = "Description : ";
    String textStartEndIndicators = "=============================";
    String h1StartingHTMLTag = "<h1>";
    String h1EndingHTMLTag = "</h1>";
    String liStartingHTMLTag = "<li>";
    String liEndingHTMLTag = "</li>";
    String ulStartingHTMLTag = "<ul>";
    String ulEndingHTMLTag = "</ul>";
    String pokemonIdHTMLLabel = "Id : ";

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(DescriptivePokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Boolean getDescriptionRequired() {
        return descriptionRequired;
    }

    public void setDescriptionRequired(Boolean descriptionRequired) {
        this.descriptionRequired = descriptionRequired;
    }



    public PokemonView() {
    }

    public PokemonView(DescriptivePokemon pokemon, Boolean descriptionRequired) {
        this.pokemon = pokemon;
        this.descriptionRequired = descriptionRequired;
    }

    @Override
    public String generateCSV() {
        String printableValue ="";
        if(this.descriptionRequired){
            printableValue = printableValue + headersCSV + headerCSVDescription
                    + "\n" + pokemon.pokemonid + ";" + pokemon.getPokemonName()
                    + ";" + pokemon.getHeigth() + ";" + pokemon.getWeigth()
                    + ";" + pokemon.getDescription();
        }else {
            printableValue = printableValue + headersCSV
                    + "\n" + pokemon.pokemonid + ";" + pokemon.getPokemonName()
                    + ";" + pokemon.getHeigth() + ";" + pokemon.getWeigth() + ";";
        }
        return printableValue;
    }

    @Override
    public String generateHTML() {
        String printableValue ="";
        printableValue = printableValue + h1StartingHTMLTag + pokemon.getPokemonName()
                + h1EndingHTMLTag + "\n" + ulStartingHTMLTag + "\n" + liStartingHTMLTag +
                pokemonIdHTMLLabel + pokemon.getPokemonid() +liEndingHTMLTag + "\n" +
                liStartingHTMLTag + pokemonHeightLabelText + pokemon.getHeigth() +
                liEndingHTMLTag + "\n" + liStartingHTMLTag + pokemon.getWeigth() +
                liEndingHTMLTag + "\n";
        if(this.descriptionRequired){
            printableValue = printableValue + liStartingHTMLTag + pokemonDescriptionLabelText
                    +pokemon.getDescription()+liEndingHTMLTag + "\n";
        }
        printableValue = printableValue + ulEndingHTMLTag;
        return printableValue;
    }

    @Override
    public String generateHumanReadableText() {
        String printableValue ="";
        printableValue = printableValue + textStartEndIndicators + "\n" +
                pokemonIdLabelText + pokemon.getPokemonid()  + "\n" +
                pokemonNameLabelText + pokemon.getPokemonName() + "\n" +
                pokemonHeightLabelText + pokemon.getHeigth() + "\n" +
                pokemonWeightLabelText + pokemon.getWeigth()  + "\n";
        if(this.descriptionRequired) {
            printableValue = printableValue + pokemonDescriptionLabelText + pokemon.getDescription() + "\n";
        }
        printableValue = printableValue + textStartEndIndicators;
        return printableValue;
    }
}
