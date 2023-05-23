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
    private Pokemon pijachu = new Pokemon("PIJACHU", Tipo.ELECTRICO, 100, 100, 100);
    public Controlador() {
        this.vista = new Vista();
        this.modelo = new PokemonDAObdd();
        this.modeloMetodos = new PokemonDaoImpl();
        PokemonDAObdd.cargarBaseDeDatos();
        //Meto un pijachu para que no salte el nullpointer ecxception
//        if(pokemones.isEmpty()) pokemones.add(pijachu);
        actualizarArrayPokemon();

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

        });
        this.vista.getBotonBorrarPokemon().addActionListener(e -> {

        });
        this.vista.getBotonCrearPokemon().addActionListener(e -> {

        });
    }

    /**
     * Muestra en el área de texto de la vista los nombres de los Pokémon almacenados en la lista de Pokémon.
     * Si la lista está vacía, muestra un mensaje de alerta.
     */
    private void listarPokemon() {
        // Verificar si la lista de Pokémon está vacía
        if (pokemones.isEmpty()){
            vista.alertar("No hay Pokemons, por favor introduce alguno!");
        }
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
    /**
     * Selecciona un Pokémon y muestra su información en los campos de texto de la vista.
     * Si el Pokémon no se encuentra, muestra un mensaje de alerta.
     *
     * @param pokemonName Nombre del Pokémon a seleccionar
     */
    private void seleccionarPokemon(String pokemonName) {
        try {
            // Leer el Pokémon por su nombre utilizando el modelo de métodos
            Pokemon pokemon = modeloMetodos.leerPorNombre(pokemonName);

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

    /**
     * Crea un nuevo Pokémon con los valores ingresados en los campos de texto de la vista.
     * Si el Pokémon ya existe en la base de datos, muestra un mensaje de alerta.
     * Si faltan datos o los valores numéricos son incorrectos, muestra mensajes de alerta correspondientes.
     * Después de crear el Pokémon, lo agrega a la base de datos y a la lista de Pokémones.
     * @throws RuntimeException Si el Pokémon ya existe en la base de datos
     */
    private void crearPokemon() {
        try {
            // Intentamos crear un Pokémon utilizando los valores de los campos de texto de la vista
            Pokemon pokemon = new Pokemon(
                    vista.getTextoNombre().getText().trim().toUpperCase(),
                    Tipo.valueOf(Objects.requireNonNull(vista.getTipoCombobox().getSelectedItem()).toString()),
                    Integer.parseInt(vista.getTextFieldVida().getText()),
                    Integer.parseInt(vista.getTextFieldAtaque().getText()),
                    Integer.parseInt(vista.getTextFieldDefensa().getText()));

            // Intentamos introducir el Pokémon creado en la base de datos
            modeloMetodos.crear(pokemon);

            // Verificamos si el Pokémon ya existe en la lista de Pokémones
            if (existePokemon(pokemon)) {
                throw new PokemonRepeatedException();
            }

            // Agregamos el Pokémon a la lista de Pokémones
            pokemones.add(pokemon);
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
    public int buscarPokemon(String nombre, int index) {

        if (pokemones.isEmpty() || index >= pokemones.size()) {
            return -1; //No se encontró el Pokémon, se devuelve -1
        }
    // // Verificar si el nombre en el índice actual coincide con el nombre buscado
        if (nombre.equals(pokemones.get(index).getNombre())) {
            return index;
            // Se encontró el Pokémon, se devuelve el índice
        }
// llamada recursiva incrementando el índice en 1 para buscar en el siguiente elemento
        return buscarPokemon(nombre, index + 1);
    }

    public void pokemonExiste(Pokemon pokemon) throws Exception {

        // Verificar si la criptomoneda ya existe en la cartera
        if (buscarPokemon(pokemon.getNombre(), 0) >= 0) {
            throw new Exception("El pokemon ya  está en la cartera");
        }
    }
    **/

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
    private void actualizarArrayPokemon() {
        modeloMetodos.leerTodos(); // Obtener todos los Pokémones del modelo
        pokemones.addAll(modeloMetodos.leerTodos()); // Agregar los Pokémones al array de Pokémones
    }
    /**
     * Genera un sonido específico para un Pokémon.
     *
     * @param pokemon El Pokémon al que se le generará el sonido.
     */
    private void pokemonSonido(Pokemon pokemon) {
        pokemon = pijachu; // Asignar el valor de "pijachu" al parámetro "pokemon"
        System.out.println("Pija pija!!!"); // Imprimir el sonido generado
    }
/** posible método para borrar pokemones
    public void borrarPokemon(Pokemon pokemon, int index) {
        // el índice está en un rango válido?
        if (index >= 0 && index < pokemones.size()) {
            // el pokemon a eliminar coincide con el actual?
            if (pokemones.get(index).equals(pokemon)) {
                pokemones.remove(index);  // Eliminar el pokemon del ArrayList
            }
        }
    }**/

  /*  private void crearPokemonC(){

    } */
}
