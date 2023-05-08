package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.util.List;

/**
 *
 * Clase que implementa los métodos de acceso a datos de la clase Pokemon
 * Esta puede hacerse mediante un fichero CSV separado por puntos y coma o una base de datos
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class PokemonDAOImp implements PokemonDAO{

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {

    }

    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        return null;
    }

    @Override
    public List<Pokemon> leerTodos() {
        return null;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {

    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {

    }
}
