package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
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
        this.pokemones = new ArrayList<Pokemon>();
        pokemones.add(0, pijachu);
        this.vista.getBotonVerListaPokemon().addActionListener(e -> {

        });
        this.vista.getBotonSeleccionarPokemon().addActionListener(e -> {

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

    private void crearPokemon(){

        try {
            modeloMetodos.leerPorNombre(vista.getTextoNombre().getText().trim().toUpperCase());
        } catch (PokemonNotFoundException e) {
            vista.alertar("Error, el Pokemon no se ha encontrado");
        }
    }

/*    private void crearPokemonC(){

    }
    private void crearPokemonC(){

    }
    private void crearPokemonC(){

    } */
}
