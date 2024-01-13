package com.example.pokedex.services;

import java.sql.*;
import java.util.List;

public class SqlDataExtraction implements DataExtractionInterface{

    String databasePathDefault = "jdbc:sqlite:src/main/resources/pokemondatabase.sqlite";
    String databasePath;

    public String getDatabasePath() {
        return databasePath;
    }

    public void setDatabasePath(String databasePath) {
        this.databasePath = databasePath;
    }

    @Override
    public List<String> getPokemonFromSource(int id) {
        Connection conn = null;

        try {
            // db parameters
            // String url = "jdbc:sqlite:../sujet_TP/ressources/pokemondatabase.sqlite";
            //String url = "jdbc:sqlite:src/main/resources/pokemondatabase.sqlite";
            //String databasePathDefault = "jdbc:sqlite:src/main/resources/pokemondatabase.sqlite";

            // create a connection to the database
            conn = DriverManager.getConnection(databasePathDefault);

            try{
                conn = DriverManager.getConnection(databasePath);
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                databasePath = databasePathDefault;
                System.out.println("No database found by parameter, Connection to default SQLite has been established.");
            }


            PreparedStatement stmt  = conn.prepareStatement("SELECT id, name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1, id); // Sets the value "3" for parameter at position 1
            try {
                ResultSet rs    = stmt.executeQuery();
                rs.next();

                //set id
                pokemonArgs.add(rs.getString("id"));
                //set name
                pokemonArgs.add(rs.getString("name"));
                //set height
                pokemonArgs.add(rs.getString("height"));
                //set weight
                pokemonArgs.add(rs.getString("weight"));
                //set description
                pokemonArgs.add(rs.getString("description"));
            } catch (Exception e){
                System.out.println("Not found entry of id in SQldatabase");
            }



            //System.out.println("Pokémon name : " + rs.getString("name"));
            //System.out.println("Pokémon description : " + rs.getString("description"));


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pokemonArgs;

    }
}
