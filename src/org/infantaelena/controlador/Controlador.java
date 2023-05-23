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

    private void listarPokemon() {
        if (pokemones.isEmpty()){
            vista.alertar("No hay Pokemons, por favor introduce alguno!");
        }
        StringBuilder sb = new StringBuilder();
        for (Pokemon pokemonFor: pokemones) {
            sb.append(pokemonFor.getNombre()).append("\n");
        }
        vista.getAreadeTexto().setText(sb.toString());

    }

    private void seleccionarPokemon(String pokemonName){

        try {
             Pokemon pokemon = modeloMetodos.leerPorNombre(pokemonName);
             vista.getTextoNombre().setText((pokemon.getNombre().trim().toUpperCase()));
             vista.getTipoCombobox().setSelectedItem(String.valueOf(pokemon.getTipo()));
             vista.getTextFieldVida().setText(String.valueOf(pokemon.getVida()));
             vista.getTextFieldAtaque().setText(String.valueOf(pokemon.getAtaque()));
             vista.getTextFieldDefensa().setText(String.valueOf(pokemon.getDefensa()));


        } catch (PokemonNotFoundException e) {
            vista.alertar("Error, el Pokemon no se ha encontrado");
        }

    }

    private void crearPokemon(){
        try {
            //Intentamos crear un Pokemon. Si los valores son null, o si se introduce !numeros en los campos númericos, se manejarán las excepciones.
            Pokemon pokemon = new Pokemon(
                    vista.getTextoNombre().getText().trim().toUpperCase(),
                    Tipo.valueOf(Objects.requireNonNull(vista.getTipoCombobox().getSelectedItem()).toString()),
                    Integer.parseInt(vista.getTextFieldVida().getText()),
                    Integer.parseInt(vista.getTextFieldAtaque().getText()),
                    Integer.parseInt(vista.getTextFieldDefensa().getText()));
            //Intentamos introducir el pokemon creado en la base de datos. Si ya existe un pokemon con ese nombre, lanzará la excepción PokemonRepeatedException e.
            modeloMetodos.crear(pokemon);
            pokemones.add(pokemon);
            if (existePokemon(pokemon)) {
                throw new PokemonRepeatedException();
            }
        } catch (PokemonRepeatedException e) {
            vista.alertar("Error, el Pokemon ya existe.");
            throw new RuntimeException(e);

        } catch (NullPointerException e){
            vista.alertar("Tienes que introducir todos los datos!");
        }  catch (NumberFormatException e) {
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
    private boolean existePokemon(Pokemon pokemon){
        boolean existe = false;
        for (Pokemon pokemonFor : pokemones) {
            if (pokemonFor.getNombre().trim().toUpperCase().equals(pokemon.getNombre().trim().toUpperCase())){
            existe = true;
            }
        }
        return existe;
    }

    private void actualizarArrayPokemon(){
        modeloMetodos.leerTodos();
        pokemones.addAll((modeloMetodos.leerTodos()));
    }

    private void pokemonSonido(Pokemon pokemon){
        pokemon = pijachu;
        System.out.println("Pija pija!!!");
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
