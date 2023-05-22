package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDaoImpl;
import org.infantaelena.modelo.dao.PokemonDAObdd;
import org.infantaelena.modelo.entidades.Tipo;
import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.entidades.Pokemon;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */


public class Controlador {

    //TODO: He borrado la linea de codigo que usabais para llamar a private PokemonDaoImp modelo; si requeris de la interfaz llamadla a traves del PokemonDAO impl.
    private Vista vista;
    private PokemonDAObdd modelo;
    private PokemonDaoImpl modeloMetodos;
    private ArrayList<Pokemon> pokemones = new ArrayList<>();
    private Pokemon pijachu = new Pokemon("PIJACHU", Tipo.ELECTRICO, 100, 100, 100);
    public Controlador() {
        this.vista = new Vista();
        this.modelo = new PokemonDAObdd();
        this.modeloMetodos = new PokemonDaoImpl();
        //TODO: hacer que la lista se actualice a la par que creas/actualizas/editas pokemones.
        this.pokemones = new ArrayList<Pokemon>();
        pokemones.add(0, pijachu);
        this.vista.getBotonVerListaPokemon().addActionListener(e -> {

        });
        this.vista.getBotonSeleccionarPokemon().addActionListener(e -> {
            seleccionarPokemon(vista.getTextoNombre().getText().trim().toUpperCase());
        });
        this.vista.getBotonCrearPokemon().addActionListener(e -> {

        });
        this.vista.getBotonActualizarPokemon().addActionListener(e -> {

        });
        this.vista.getBotonBorrarPokemon().addActionListener(e -> {

        });
        this.vista.getBotonGuardarPokemon().addActionListener(e -> {

        });
    }

    private void listarPokemon() {
        pokemones = (ArrayList<Pokemon>) modeloMetodos.leerTodos();
        //TODO: imprimirTexto, for each del arraylist que utilice pokemones.
      //  vista.imprimirTexto();
    }

    private void seleccionarPokemon(String pokemonName){

        try {
             Pokemon pokemon = modeloMetodos.leerPorNombre(pokemonName);
             vista.getTextoNombre().setText((pokemon.getNombre()));
             vista.getTipoCombobox().setSelectedItem(String.valueOf(pokemon.getTipo()));
             vista.getTextFieldVida().setText(String.valueOf(pokemon.getVida()));
             vista.getTextFieldAtaque().setText(String.valueOf(pokemon.getAtaque()));
             vista.getTextFieldDefensa().setText(String.valueOf(pokemon.getDefensa()));


        } catch (PokemonNotFoundException e) {
            vista.alertar("Error, el Pokemon no se ha encontrado");
        }

    }

    private void crearPokemon(){
        Pokemon pokemon = new Pokemon(
                vista.getTextoNombre().getText(),
                Tipo.valueOf(vista.getTipoCombobox().getSelectedItem().toString()),
                Integer.parseInt(vista.getTextFieldVida().getText()),
                Integer.parseInt(vista.getTextFieldVida().getText()),
                Integer.parseInt(vista.getTextFieldVida().getText()));
        try {
            modeloMetodos.crear(pokemon);
        } catch (PokemonRepeatedException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e){
            vista.alertar("Tienes que introducir todos los datos!");
        }

    }

/*

    }
    private void crearPokemonC(){

    }
    private void crearPokemonC(){

    } */
}
