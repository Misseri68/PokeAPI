package org.infantaelena.vista;
import javax.swing.*;

public class PokemonView extends javax.swing.JFrame {
    private javax.swing.JPanel panel;
    private javax.swing.JLabel ataqueLabel;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JLabel vidaLabel;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JLabel defensaLabel;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField pokeAPITextField;
    private javax.swing.JComboBox<String> comboboxTipo;
    private javax.swing.JButton seleccionarPokemon;
    private javax.swing.JButton crearPokemonButton;
    private javax.swing.JButton actualizarPokemon;
    private javax.swing.JButton verListaPokemonButton;
    private javax.swing.JButton guardarPokemonButton;

    public JButton getActualizarPokemon() {
        return actualizarPokemon;
    }

    public void setActualizarPokemon(JButton actualizarPokemon) {
        this.actualizarPokemon = actualizarPokemon;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JButton getBorrarPokemon() {
        return borrarPokemon;
    }

    public void setBorrarPokemon(JButton borrarPokemon) {
        this.borrarPokemon = borrarPokemon;
    }

    private JTextArea textArea1;
    private javax.swing.JButton borrarPokemon;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getAtaqueLabel() {
        return ataqueLabel;
    }

    public void setAtaqueLabel(JLabel ataqueLabel) {
        this.ataqueLabel = ataqueLabel;
    }

    public JLabel getNombreLabel() {
        return NombreLabel;
    }

    public void setNombreLabel(JLabel nombreLabel) {
        NombreLabel = nombreLabel;
    }

    public JLabel getVidaLabel() {
        return vidaLabel;
    }

    public void setVidaLabel(JLabel vidaLabel) {
        this.vidaLabel = vidaLabel;
    }

    public JLabel getTipoLabel() {
        return tipoLabel;
    }

    public void setTipoLabel(JLabel tipoLabel) {
        this.tipoLabel = tipoLabel;
    }

    public JLabel getDefensaLabel() {
        return defensaLabel;
    }

    public void setDefensaLabel(JLabel defensaLabel) {
        this.defensaLabel = defensaLabel;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(JTextField textoNombre) {
        this.textoNombre = textoNombre;
    }

    public JTextField getPokeAPITextField() {
        return pokeAPITextField;
    }

    public void setPokeAPITextField(JTextField pokeAPITextField) {
        this.pokeAPITextField = pokeAPITextField;
    }

    public JComboBox<String> getComboboxTipo() {
        return comboboxTipo;
    }

    public void setComboboxTipo(JComboBox<String> comboboxTipo) {
        this.comboboxTipo = comboboxTipo;
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

    public JButton getCargarListaButton() {
        return actualizarPokemon;
    }

    public void setCargarListaButton(JButton cargarListaButton) {
        this.actualizarPokemon = cargarListaButton;
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



    public PokemonView() {
        initComponents();
        setContentPane(panel);
        setVisible(true);
    }

    private void initComponents() {
        panel = new javax.swing.JPanel();
        ataqueLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        vidaLabel = new javax.swing.JLabel();
        tipoLabel = new javax.swing.JLabel();
        defensaLabel = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        pokeAPITextField = new javax.swing.JTextField();
        comboboxTipo = new javax.swing.JComboBox<>();
        seleccionarPokemon = new javax.swing.JButton();
        crearPokemonButton = new javax.swing.JButton();
        actualizarPokemon = new javax.swing.JButton();
        verListaPokemonButton = new javax.swing.JButton();
        guardarPokemonButton=new javax.swing.JButton();
        borrarPokemon=new javax.swing.JButton();
        textArea1=new javax.swing.JTextArea();

        panel.add(ataqueLabel);
        panel.add(NombreLabel);
        panel.add(vidaLabel);
        panel.add(tipoLabel);
        panel.add(defensaLabel);
        panel.add(textoNombre);
        panel.add(pokeAPITextField);
        panel.add(comboboxTipo);
        panel.add(seleccionarPokemon);
        panel.add(crearPokemonButton);
        panel.add(actualizarPokemon);
        panel.add(verListaPokemonButton);
        panel.add(guardarPokemonButton);
        panel.add(borrarPokemon);
        panel.add(textArea1);

    }
}