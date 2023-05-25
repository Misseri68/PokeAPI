package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;
import org.infantaelena.modelo.entidades.Tipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonImpTest {
    private PokemonDaoImpl pokemonDAO;
    @BeforeEach
    void setup(){
        pokemonDAO = new PokemonDaoImpl();
    }

    @org.junit.jupiter.api.Test
    void crear() {
        Pokemon pokemon = new Pokemon();
        pokemon.setNombre("Pikachu");
        pokemon.setTipo(Tipo.ELECTRICO);
        pokemon.setVida(100);
        pokemon.setAtaque(50);
        pokemon.setDefensa(30);

        //Intentar Crear el Pokemon.
        try {
            pokemonDAO.crear(pokemon);
        } catch (PokemonRepeatedException e) {
            Assertions.fail("No se esperaba un pokemon Repetido");
        }
        //Comprobar que el pokemon se ha creado.

        try {
            Pokemon pokemonCreado = pokemonDAO.leerPorNombre("Pikachu");
            Assertions.assertEquals(pokemon.getNombre().toUpperCase(), pokemonCreado.getNombre());
            Assertions.assertEquals(pokemon.getTipo(), pokemonCreado.getTipo());
            Assertions.assertEquals(pokemon.getVida(), pokemonCreado.getVida());
            Assertions.assertEquals(pokemon.getAtaque(), pokemonCreado.getAtaque());
            Assertions.assertEquals(pokemon.getDefensa(), pokemonCreado.getDefensa());
        } catch (PokemonNotFoundException e) {
            Assertions.fail("Se esperaba encontrar pokemon recien Creado");
        }
    }

    @org.junit.jupiter.api.Test
    void leerPorNombre() {
        //Intentar Leer Pokemon existente por nombre
        try {
            Pokemon pokemon = pokemonDAO.leerPorNombre("Pikachu");
            Assertions.assertEquals("PIKACHU", pokemon.getNombre());
            Assertions.assertEquals(Tipo.ELECTRICO, pokemon.getTipo());
            Assertions.assertEquals(100, pokemon.getVida());
            Assertions.assertEquals(50, pokemon.getAtaque());
            Assertions.assertEquals(30, pokemon.getDefensa());
        } catch (PokemonNotFoundException e) {
            Assertions.fail("No se ha encontrado al Pokemon");
        }
    }

    @org.junit.jupiter.api.Test
    void leerTodos() {
        //Atraparlos a todos.
        List<Pokemon> pokemons = pokemonDAO.leerTodos();
        Assertions.assertFalse(pokemons.isEmpty());
        Assertions.assertEquals(2, pokemons.size());
    }

    @org.junit.jupiter.api.Test
    void actualizar() {
        try {
            Pokemon pokemon = pokemonDAO.leerPorNombre("Pikachu");

            //Modificamos los Atributos
            pokemon.setVida(90);
            pokemon.setAtaque(30);
            pokemon.setDefensa(40);

            pokemonDAO.actualizar(pokemon);

            Pokemon pokemonActualizado = pokemonDAO.leerPorNombre("Pikachu");

            Assertions.assertEquals(90, pokemonActualizado.getVida());
            Assertions.assertEquals(30, pokemonActualizado.getAtaque());
            Assertions.assertEquals(40, pokemonActualizado.getDefensa());
        } catch (PokemonNotFoundException e ) {
            Assertions.fail("No se esperaba no encontrar al pokemon");
        }
    }

    @org.junit.jupiter.api.Test
    void eliminarPorNombre() {
        try {
            pokemonDAO.eliminarPorNombre("Pikachu");
            //Intentamos leer por nombre
            pokemonDAO.leerPorNombre("Pikachu");
            Assertions.fail("Se esperaba una excepcion PokemonNotFound");
        } catch (PokemonNotFoundException e) {
            Assertions.assertTrue(true);
        }
    }
}