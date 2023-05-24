package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDaoImpl;
import org.infantaelena.modelo.dao.PokemonDAObdd;
import org.infantaelena.modelo.entidades.Tipo;
import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.entidades.Pokemon;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author Ariadna López, Dragos Alexandru y Adriana Aránguez
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
    //Esto de aquí es una broma nacida de un accidente de ortografía, que se ha quedado como Easter Egg.
    private Pokemon pijachu = new Pokemon("PIJACHU", Tipo.ELECTRICO, 100, 100, 100);
    public Controlador() {
        this.vista = new Vista();
        this.modelo = new PokemonDAObdd();
        this.modeloMetodos = new PokemonDaoImpl();
        PokemonDAObdd.cargarBaseDeDatos();
        listarPokemon();

        this.vista.getBotonVerListaPokemon().addActionListener(e -> {
            listarPokemon();
        });
        this.vista.getBotonSeleccionarPokemon().addActionListener(e -> {
            seleccionarPokemon(vista.getTextoNombre().getText().trim().toUpperCase());
        });
        this.vista.getBotonCrearPokemon().addActionListener(e -> {
            crearPokemon();
        });
        this.vista.getBotonActualizarPokemon().addActionListener(e -> {
            actualizarPokemon();
        });
        this.vista.getBotonBorrarPokemon().addActionListener(e -> {

        });
        this.vista.getFiltrarPorTipo().addActionListener(e -> {

        });
    }

    /**
     * Muestra en el área de texto de la vista los nombres de los Pokémon almacenados en la lista de Pokémon.
     * Si la lista está vacía, muestra un mensaje de alerta.
     */
    private void listarPokemon() {
        recargarArrayPokemon();
        // Verificar si la lista de Pokémon está vacía
        if (pokemones.isEmpty()){
            vista.alertar("No hay Pokemon, por favor introduce alguno!");
        }
        else{
            // Crear un StringBuilder para construir el contenido a mostrar en el área de texto
            StringBuilder sb = new StringBuilder();
            // Iterar sobre cada Pokémon en la lista de Pokémon
            for (Pokemon pokemonFor: pokemones) {
                // Agregar el nombre del Pokémon actual al StringBuilder, seguido de un salto de línea
                sb.append(pokemonFor.getNombre()).append("\n");
            }
            // Establecer el texto construido en el área de texto de la vista
            vista.getAreadeTexto().setText(sb.toString());
        }
    }
    /**
     * Selecciona un Pokémon y muestra su información en los campos de texto de la vista.
     * Si el Pokémon no se encuentra, muestra un mensaje de alerta.
     *
     * @param pokemonName Nombre del Pokémon a seleccionar
     */
    private void seleccionarPokemon(String pokemonName) {
       if (pokemonName.toUpperCase().trim().equals("PIJACHU")) pokemonSonido();
       else {
           try {
               // Leer el Pokémon por su nombre utilizando el método de modelo.
               Pokemon pokemon = modeloMetodos.leerPorNombre(pokemonName.toUpperCase().trim());
               // Establecer los valores del Pokémon en los campos de texto de la vista
               vista.getTextoNombre().setText((pokemon.getNombre().trim().toUpperCase()));
               vista.getTipoCombobox().setSelectedItem(String.valueOf(pokemon.getTipo()));
               vista.getTextFieldVida().setText(String.valueOf(pokemon.getVida()));
               vista.getTextFieldAtaque().setText(String.valueOf(pokemon.getAtaque()));
               vista.getTextFieldDefensa().setText(String.valueOf(pokemon.getDefensa()));
           } catch (PokemonNotFoundException e) {
               vista.alertar("Error, el Pokémon no se ha encontrado");
           }
       }
    }

    /**
     * Crea un nuevo Pokémon con los valores ingresados en los campos de texto de la vista.
     * Si el Pokémon ya existe en la base de datos, muestra un mensaje de alerta.
     * Si faltan datos o los valores numéricos son incorrectos, muestra mensajes de alerta correspondientes.
     * Después de crear el Pokémon, lo agrega a la base de datos y a la lista de Pokémones.
     * @throws RuntimeException Si el Pokémon ya existe en la base de datos
     */
    private void crearPokemon() {
        // Intentamos crear un Pokémon utilizando los valores de los campos de texto de la vista
        Pokemon pokemon = new Pokemon(
                vista.getTextoNombre().getText().trim().toUpperCase(),
                Tipo.valueOf(Objects.requireNonNull(vista.getTipoCombobox().getSelectedItem()).toString()),
                Integer.parseInt(vista.getTextFieldVida().getText()),
                Integer.parseInt(vista.getTextFieldAtaque().getText()),
                Integer.parseInt(vista.getTextFieldDefensa().getText())
        );
        try {
            //TODO preguntar a carlos si lo quiere aqui o en modelo
            if (existePokemon(pokemon)) throw new PokemonRepeatedException();
            // Si no salta el throw, introducimos el Pokémon creado en la base de datos y reiniciamos el arrayList pokemones
            modeloMetodos.crear(pokemon);
            recargarArrayPokemon();
            listarPokemon();
            // Confirmamos al usuario que se ha agregado correctamente.
            vista.alertar("Pokemon agregado correctamente.");
        } catch (PokemonRepeatedException e) {
            vista.alertar("Error, el Pokémon ya existe.");
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            vista.alertar("Tienes que introducir todos los datos!");
        } catch (NumberFormatException e) {
            vista.alertar("Los valores de vida, ataque y defensa deben ser números enteros!");
        }
    }

    private void actualizarPokemon(){
        Pokemon pokemon = new Pokemon(
                vista.getTextoNombre().getText().trim().toUpperCase(),
                Tipo.valueOf(Objects.requireNonNull(vista.getTipoCombobox().getSelectedItem()).toString()),
                Integer.parseInt(vista.getTextFieldVida().getText()),
                Integer.parseInt(vista.getTextFieldAtaque().getText()),
                Integer.parseInt(vista.getTextFieldDefensa().getText())

        );
        try{
            modeloMetodos.actualizar(pokemon);
            recargarArrayPokemon();
            vista.alertar("Pokemon actualizado correctamente!");
        } catch (PokemonNotFoundException e){
            vista.alertar("Error, el Pokémon no se ha encontrado");
        }
    }




    /**
     * Verifica si un Pokémon ya existe en la lista de Pokémones.
     * @param pokemon El Pokémon a verificar
     * @return true si el Pokémon ya existe, false en caso contrario
     */
    private boolean existePokemon(Pokemon pokemon){
        boolean existe = false;
        for (Pokemon pokemonFor : pokemones) {
            if (pokemonFor.getNombre().trim().toUpperCase().equals(pokemon.getNombre().trim().toUpperCase())){
            existe = true;
            }
        }
        return existe;
    }
    /**
     * Actualiza el array de Pokémones utilizando los datos obtenidos del modelo.
     */
    private void recargarArrayPokemon() {
        modeloMetodos.leerTodos(); // Obtener todos los Pokémones del modelo
        pokemones.clear();
        pokemones.addAll(modeloMetodos.leerTodos()); // Agregar los Pokémones al array de Pokémones
    }

    //Esto de aquí es un Easter Egg
    private void pokemonSonido() {
        vista.alertar("PIJA PIJA!!!! ( ͡° ͜ʖ ͡°)");
    }

}
