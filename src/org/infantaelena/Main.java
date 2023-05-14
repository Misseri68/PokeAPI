package org.infantaelena;

import org.infantaelena.controlador.Controlador;
import org.infantaelena.modelo.dao.PokemonDAObdd;

public class Main

{

    public static void main(String args[]) {

        Controlador controlador = new Controlador();
        new Controlador();

        PokemonDAObdd.cargarBaseDeDatos();
        controlador.seleccionarBDD();
    }

}