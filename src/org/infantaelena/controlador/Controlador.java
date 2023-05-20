package org.infantaelena.controlador;

import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.entidades.Pokemon;
import java.util.ArrayList;

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

    ArrayList<Pokemon> students = new ArrayList<>();

    public Controlador() {
        // modelo = new PokemonDAOImp("");
        vista = new Vista();
    }
}
