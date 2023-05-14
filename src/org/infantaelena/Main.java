package org.infantaelena;

import org.infantaelena.controlador.Controlador;
import org.infantaelena.modelo.dao.PokemonDAObdd;

public class Main

{

    public static void main(String args[]) {

        new Controlador();

        PokemonDAObdd.cargarBaseDeDatos();

    }

}