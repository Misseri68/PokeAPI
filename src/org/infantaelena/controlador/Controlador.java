package org.infantaelena.controlador;

import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.dao.PokemonDAOImp;
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


    private PokemonDAOImp modelo;
    private Vista vista;

    ArrayList<Pokemon> students = new ArrayList<>();

    public Controlador() {
        // modelo = new PokemonDAOImp("");
        vista = new Vista();
    }
}
