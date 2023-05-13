package org.infantaelena.vista;

import javax.swing.*;

public class VistaPrueba {
    private JButton CargarLista;
    private JButton VerLista;
    private JButton SeleccionarPokemon;
    private JButton crearPokemonButton;
    private JButton guardarPokemonButton;
    private JButton guardarCambiosButton;

    public JButton getCargarLista() {
        return CargarLista;
    }

    public void setCargarLista(JButton cargarLista) {
        CargarLista = cargarLista;
    }

    public JButton getVerLista() {
        return VerLista;
    }

    public void setVerLista(JButton verLista) {
        VerLista = verLista;
    }

    public JButton getSeleccionarPokemon() {
        return SeleccionarPokemon;
    }

    public void setSeleccionarPokemon(JButton seleccionarPokemon) {
        SeleccionarPokemon = seleccionarPokemon;
    }

    public JButton getCrearPokemonButton() {
        return crearPokemonButton;
    }

    public void setCrearPokemonButton(JButton crearPokemonButton) {
        this.crearPokemonButton = crearPokemonButton;
    }

    public JButton getGuardarPokemonButton() {
        return guardarPokemonButton;
    }

    public void setGuardarPokemonButton(JButton guardarPokemonButton) {
        this.guardarPokemonButton = guardarPokemonButton;
    }

    public JButton getGuardarCambiosButton() {
        return guardarCambiosButton;
    }

    public void setGuardarCambiosButton(JButton guardarCambiosButton) {
        this.guardarCambiosButton = guardarCambiosButton;
    }


    private void createUIComponents() {

    }
}
