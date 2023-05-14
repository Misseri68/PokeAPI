package org.infantaelena.controlador;

import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

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
    Scanner scanner = new Scanner(System.in);
    private PokemonDAOImp modelo;
    private Vista vista;

    ArrayList<Pokemon> students = new ArrayList<>();

    public Controlador() {
        //modelo = new PokemonDAOImp("nombre_de_base_de_datos_a_cargar");
        vista = new Vista();
    }

    //TODO: meter el método seleccionarBDD(con seleccionarBDD como String de argumento) en el main method


    public String seleccionarBDD(){
        //Primero listará todas las bases de datos de la carpeta bbdd
        //Usará el System.getProperty() para averiguar la ruta de la carpeta bbdd.

        File carpeta = new File(System.getProperty("user.dir") + "/bbdd");
        File[] arrayArchivos = carpeta.listFiles();
        // Aquí hacemos que sea un array dinámico:

        ArrayList<File> saveList = new ArrayList<File>(Arrays.asList(arrayArchivos));

        //Le presentamos la lista al usuario
        //TODO: está hecho por consola, pero hay que hacerlo con la interfaz (quizá puedes meter una pequeña consola en ella)S
        System.out.println("Elige un archivo de guardado:");
        for (int i = 0; i < saveList.size(); i++) {
            //El usuario verá la primera opción como 1 en vez de 0, así que habrá que restarle un 1 a la selección de usuario en el scanner.
            System.out.println((i+1) + ". " + saveList.get(i).getName());
        }

        //TODO: Registramos el input del user por scanner y le restamos 1 (como dicho en el bucle for de antes).
        //int seleccion = scanner.nextInt()-1;
        //Pongo por defecto la base de datos pokemon.db para facilitar las pruebas
        int seleccion = 0;
        return saveList.get(seleccion).getName();
    }
}
