package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.infantaelena.modelo.entidades.Tipo;

/**
 *
 * Interfaz que define los métodos de acceso a datos de la clase Pokemon
 * @author Ariadna López, Dragos Alexandru y Adriana Aránguez
 * @version 24/04/2023
 *
 */
public interface PokemonDAO {

    // Método para crear un nuevo Pokemon
    public void crear(Pokemon pokemon) throws PokemonRepeatedException;

    // Método para leer un Pokemon de la base de datos por su nombre
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException;

    // Método para leer todos los Pokemons
    public List<Pokemon> leerTodos() ;

    // Método para actualizar un Pokemon en la base de datos
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException;

    // Método para eliminar un Pokemon por su nombre
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException;

}
