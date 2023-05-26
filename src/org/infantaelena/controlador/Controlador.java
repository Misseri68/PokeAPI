package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDaoImpl;
import org.infantaelena.modelo.dao.PokemonDAObdd;
import org.infantaelena.modelo.entidades.Tipo;
import org.infantaelena.vista.Vista;
import org.infantaelena.vista.PreguntarparaEliminar;
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

    private Vista vista;
    private PreguntarparaEliminar preguntarparaEliminar;
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
        this.vista.getBotonVerListaPokemon().addActionListener(e -> {listarPokemon();});
        this.vista.getFiltrarPorTipo().addActionListener(e -> {
//TODO
        });
        this.vista.getBotonSeleccionarPokemon().addActionListener(e -> {seleccionarPokemon(vista.getTextoNombre().getText().trim().toUpperCase());});
        this.vista.getBotonCrearPokemon().addActionListener(e -> {crearPokemon();});
        this.vista.getBotonActualizarPokemon().addActionListener(e -> {actualizarPokemon();});
        this.vista.getBotonBorrarPokemon().addActionListener(e -> {
            this.preguntarparaEliminar= new PreguntarparaEliminar();
            this.preguntarparaEliminar.getSIButton().addActionListener(ex -> {
                preguntarparaEliminar.dispose();
                borrarPokemon();
            });
            this.preguntarparaEliminar.getNOButton().addActionListener(ex -> {preguntarparaEliminar.dispose();});
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
            vista.getAreadeTexto().setText("");
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
        String nombrePokemon = vista.getTextoNombre().getText().trim().toUpperCase();
        // Intentamos crear un Pokémon utilizando los valores de los campos de texto de la vista

        try {
            Pokemon pokemon = new Pokemon(
                    nombrePokemon,
                    Tipo.valueOf(Objects.requireNonNull(vista.getTipoCombobox().getSelectedItem()).toString()),
                    Integer.parseInt(vista.getTextFieldVida().getText()),
                    Integer.parseInt(vista.getTextFieldAtaque().getText()),
                    Integer.parseInt(vista.getTextFieldDefensa().getText())
            );
            if (existePokemon(nombrePokemon)) throw new PokemonRepeatedException();
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

    /**
     * Actualiza un Pokémon en el sistema.
     */
    private void actualizarPokemon() {
        // Obtiene el nombre del Pokémon ingresado en la vista y lo convierte a mayúsculas
        String nombrePokemon = vista.getTextoNombre().getText().trim().toUpperCase();

        try {
            // Crea un nuevo objeto Pokémon con los datos ingresados en la vista
            Pokemon pokemon = new Pokemon(
                    nombrePokemon,
                    Tipo.valueOf(Objects.requireNonNull(vista.getTipoCombobox().getSelectedItem()).toString()),
                    Integer.parseInt(vista.getTextFieldVida().getText()),
                    Integer.parseInt(vista.getTextFieldAtaque().getText()),
                    Integer.parseInt(vista.getTextFieldDefensa().getText())
            );

            // Verifica si el Pokémon existe en el sistema
            if (!existePokemon(nombrePokemon)) {
                throw new PokemonNotFoundException(); // Lanza una excepción si el Pokémon no se encuentra
            } else {
                // Actualiza el Pokémon en el modelo de datos
                modeloMetodos.actualizar(pokemon);

                // Recarga el array de Pokémon en la vista
                recargarArrayPokemon();

                // Muestra un mensaje de alerta indicando que el Pokémon se ha actualizado correctamente
                vista.alertar("Pokemon actualizado correctamente!");
            }
        } catch (PokemonNotFoundException e) {
            // Captura la excepción de Pokémon no encontrado y muestra un mensaje de alerta correspondiente
            vista.alertar("Error, el Pokémon no se ha encontrado");
        } catch (NullPointerException e) {
            // Captura la excepción de puntero nulo y muestra un mensaje de alerta correspondiente
            vista.alertar("Tienes que introducir todos los datos!");
        } catch (NumberFormatException e) {
            // Captura la excepción de formato de número incorrecto y muestra un mensaje de alerta correspondiente
            vista.alertar("Los valores de vida, ataque y defensa deben ser números enteros!");
        }
    }

    //TODO: arreglarlo
    /**
     * Borra un Pokémon del sistema.
     */
    private void borrarPokemon() {
        // Obtiene el nombre del Pokémon ingresado en la vista y lo convierte a mayúsculas
        String nombrePokemon = vista.getTextoNombre().getText().trim().toUpperCase();

        try {
            // Verifica si el Pokémon existe en el sistema
            if (!existePokemon(nombrePokemon)) {
                throw new PokemonNotFoundException(); // Lanza una excepción si el Pokémon no se encuentra
            } else {
                // Elimina el Pokémon del modelo de datos por su nombre
                modeloMetodos.eliminarPorNombre(nombrePokemon);

                // Muestra un mensaje de alerta indicando que el Pokémon ha sido eliminado correctamente
                vista.alertar("Pokemon asesinado correctamente! =)");

                // Vuelve a listar los Pokémon en la vista
                listarPokemon();
            }
        } catch (PokemonNotFoundException e) {
            // Captura la excepción de Pokémon no encontrado y muestra un mensaje de alerta correspondiente
            vista.alertar("Error, el Pokémon no se ha encontrado");
        }
    }



    /**
     * Verifica si un Pokémon ya existe en la lista de Pokémones.
     * @param nombrePokemon El Pokémon a verificar
     * @return true si el Pokémon ya existe, false en caso contrario
     */
    private boolean existePokemon(String nombrePokemon){
        recargarArrayPokemon();
        boolean existe = false;
        for (Pokemon pokemonFor : pokemones) {
            if (pokemonFor.getNombre().trim().toUpperCase().equals(nombrePokemon)){
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