package org.infantaelena.vista;
import javax.swing.*;
import java.awt.*;

public class PokemonView extends JFrame {
    private JLabel ataqueLabel;

    public JLabel getAtaqueLabel() {
        return ataqueLabel;
    }

    public void setAtaqueLabel(JLabel ataqueLabel) {
        this.ataqueLabel = ataqueLabel;
    }

    public JLabel getDefensaLabel() {
        return defensaLabel;
    }

    public void setDefensaLabel(JLabel defensaLabel) {
        this.defensaLabel = defensaLabel;
    }

    public JTextField getTextFieldVida() {
        return textFieldVida;
    }

    public void setTextFieldVida(JTextField textFieldVida) {
        this.textFieldVida = textFieldVida;
    }

    public JTextField getTextFieldAtaque() {
        return textFieldAtaque;
    }

    public void setTextFieldAtaque(JTextField textFieldAtaque) {
        this.textFieldAtaque = textFieldAtaque;
    }

    public JTextField getTextFieldDefensa() {
        return textFieldDefensa;
    }

    public void setTextFieldDefensa(JTextField textFieldDefensa) {
        this.textFieldDefensa = textFieldDefensa;
    }

    public JLabel getTipoLabel() {
        return tipoLabel;
    }

    public void setTipoLabel(JLabel tipoLabel) {
        this.tipoLabel = tipoLabel;
    }

    public JLabel getVidaLabel() {
        return vidaLabel;
    }

    public void setVidaLabel(JLabel vidaLabel) {
        this.vidaLabel = vidaLabel;
    }

    public JComboBox<String> getTipoCombobox() {
        return tipoCombobox;
    }

    public void setTipoCombobox(JComboBox<String> tipoCombobox) {
        this.tipoCombobox = tipoCombobox;
    }

    public JButton getSeleccionarPokemon() {
        return seleccionarPokemon;
    }

    public void setSeleccionarPokemon(JButton seleccionarPokemon) {
        this.seleccionarPokemon = seleccionarPokemon;
    }

    public JButton getCrearPokemonButton() {
        return crearPokemonButton;
    }

    public void setCrearPokemonButton(JButton crearPokemonButton) {
        this.crearPokemonButton = crearPokemonButton;
    }

    public JButton getActualizarPokemon() {
        return actualizarPokemon;
    }

    public void setActualizarPokemon(JButton actualizarPokemon) {
        this.actualizarPokemon = actualizarPokemon;
    }

    public JButton getVerListaPokemonButton() {
        return verListaPokemonButton;
    }

    public void setVerListaPokemonButton(JButton verListaPokemonButton) {
        this.verListaPokemonButton = verListaPokemonButton;
    }

    public JButton getGuardarPokemonButton() {
        return guardarPokemonButton;
    }

    public void setGuardarPokemonButton(JButton guardarPokemonButton) {
        this.guardarPokemonButton = guardarPokemonButton;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(JTextField textoNombre) {
        this.textoNombre = textoNombre;
    }

    public JLabel getNombreLabel() {
        return nombreLabel;
    }

    public void setNombreLabel(JLabel nombreLabel) {
        this.nombreLabel = nombreLabel;
    }

    public JTextField getPokeAPITextField() {
        return pokeAPITextField;
    }

    public void setPokeAPITextField(JTextField pokeAPITextField) {
        this.pokeAPITextField = pokeAPITextField;
    }

    public JTextArea getAreadeTexto() {
        return areadeTexto;
    }

    public void setAreadeTexto(JTextArea areadeTexto) {
        this.areadeTexto = areadeTexto;
    }

    public JButton getBorrarPokemon() {
        return borrarPokemon;
    }

    public void setBorrarPokemon(JButton borrarPokemon) {
        this.borrarPokemon = borrarPokemon;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getTextfieldVida() {
        return textfieldVida;
    }

    public void setTextfieldVida(JTextField textfieldVida) {
        this.textfieldVida = textfieldVida;
    }

    public JTextField getTextfieldAtaque() {
        return textfieldAtaque;
    }

    public void setTextfieldAtaque(JTextField textfieldAtaque) {
        this.textfieldAtaque = textfieldAtaque;
    }

    public JTextField getTextfieldDefensa() {
        return textfieldDefensa;
    }

    public void setTextfieldDefensa(JTextField textfieldDefensa) {
        this.textfieldDefensa = textfieldDefensa;
    }

    public JLabel getDefensa() {
        return defensa;
    }

    public void setDefensa(JLabel defensa) {
        this.defensa = defensa;
    }

    private JLabel defensaLabel;
    private JTextField textFieldVida;
    private JTextField textFieldAtaque;
    private JTextField textFieldDefensa;
    private JLabel tipoLabel;
    private JLabel vidaLabel;
    private JComboBox<String> tipoCombobox;
    private JButton seleccionarPokemon;
    private JButton crearPokemonButton;
    private JButton actualizarPokemon;
    private JButton verListaPokemonButton;
    private JButton guardarPokemonButton;
    private JTextField textoNombre;
    private JLabel nombreLabel;
    private JTextField pokeAPITextField;
    private JTextArea areadeTexto;
    private JButton borrarPokemon;
    private JPanel panel;
    private JTextField textfieldVida;
    private JTextField textfieldAtaque;
    private JTextField textfieldDefensa;
    private JLabel defensa;

    public PokemonView() {
        super("pokeAPI");
        setContentPane(panel);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PokemonView();
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        });
}
}