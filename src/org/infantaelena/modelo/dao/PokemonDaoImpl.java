package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;
import org.infantaelena.modelo.entidades.Tipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PokemonDaoImpl implements PokemonDAO {
String databaseFileName = "pokeapi.db";
    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {
            String insertarQuery = "INSERT INTO Pokemon (nombre, tipo, vida, ataque, defensa) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertarQuery)) {
                preparedStatement.setString(1, pokemon.getNombre().trim().toUpperCase());
                preparedStatement.setString(2, String.valueOf(pokemon.getTipo()));
                preparedStatement.setInt(3, pokemon.getVida());
                preparedStatement.setInt(4, pokemon.getAtaque());
                preparedStatement.setInt(5, pokemon.getDefensa());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el Pokemon.");
        }
    }

    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        Pokemon pokemon = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {
            String seleccionarQuery = "SELECT * FROM Pokemon WHERE nombre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(seleccionarQuery)) {
                preparedStatement.setString(1, nombre.trim().toUpperCase());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        pokemon = new Pokemon();
                        pokemon.setId(resultSet.getInt("id"));
                        pokemon.setNombre(resultSet.getString("nombre").trim().toUpperCase());
                        pokemon.setTipo(Tipo.valueOf(resultSet.getString("tipo")));
                        pokemon.setVida(resultSet.getInt("vida"));
                        pokemon.setAtaque(resultSet.getInt("ataque"));
                        pokemon.setDefensa(resultSet.getInt("defensa"));
                    } else {
                        throw new PokemonNotFoundException("Pokemon no encontrado");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al leer el Pokemon por nombre.");
        }
        return pokemon;
    }

    @Override
    public List<Pokemon> leerTodos() {
        List<Pokemon> pokemons = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {
            String seleccionarQuery = "SELECT * FROM Pokemon";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(seleccionarQuery)) {
                while (resultSet.next()) {
                    Pokemon pokemon = new Pokemon();
                    pokemon.setId(resultSet.getInt("id"));
                    pokemon.setNombre(resultSet.getString("nombre").trim().toUpperCase());
                    pokemon.setTipo(Tipo.valueOf(resultSet.getString("tipo")));
                    pokemon.setVida(resultSet.getInt("vida"));
                    pokemon.setAtaque(resultSet.getInt("ataque"));
                    pokemon.setDefensa(resultSet.getInt("defensa"));
                    pokemons.add(pokemon);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los Pokemon.");
        }
        return pokemons;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {
            String actualizarQuery = "UPDATE Pokemon SET nombre = ?, tipo = ?, vida = ?, ataque = ?, defensa = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(actualizarQuery)) {
                preparedStatement.setString(1, pokemon.getNombre().trim().toUpperCase());
                preparedStatement.setString(2, String.valueOf(pokemon.getTipo()));
                preparedStatement.setInt(3, pokemon.getVida());
                preparedStatement.setInt(4, pokemon.getAtaque());
                preparedStatement.setInt(5, pokemon.getDefensa());
                preparedStatement.setInt(6, pokemon.getId());
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PokemonNotFoundException("Pokemon no encontrado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Pokemon.");
        }
    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {
            String borrarQuery = "DELETE FROM Pokemon WHERE nombre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(borrarQuery)) {
                preparedStatement.setString(1, nombre.trim().toUpperCase());
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PokemonNotFoundException("Pokemon no encontrado");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar al pokemon por nombre.");
        }
    }
}
