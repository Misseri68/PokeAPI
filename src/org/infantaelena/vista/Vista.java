package org.infantaelena.vista;
import org.infantaelena.modelo.entidades.Tipo;
import javax.swing.*;
import java.util.ArrayList;
import java.util.EnumSet;


/**
 * Clase que representa la vista de la aplicación
 * Implementar con menus de texto o con interfaz gráfica
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class Vista extends JFrame {
    private JLabel ataqueLabel;
    private JLabel defensaLabel;
    private JTextField textFieldVida;
    private JTextField textFieldAtaque;
    private JTextField textFieldDefensa;
    private JLabel tipoLabel;
    private JLabel vidaLabel;
    private JComboBox<Tipo> tipoCombobox;
    private JButton botonSeleccionarPokemon;
    private JButton botonCrearPokemon;
    private JButton botonActualizarPokemon;
    private JButton botonVerListaPokemon;
    private JButton botonBorrarPokemon;
    private JTextField textoNombre;
    private JLabel nombreLabel;
    private JLabel pokeAPILabel;
    private JTextArea areadeTexto;
    private JPanel panel;
    private JTextField textfieldVida;
    private JTextField textfieldAtaque;
    private JTextField textfieldDefensa;
    private JLabel defensa;
    private JButton filtrarPorTipo;
    private ArrayList<Tipo> tipoEnum = new ArrayList<>(EnumSet.allOf(Tipo.class));


    public Vista() {
        super("pokeAPI");
        setContentPane(panel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        for (Tipo tipoEnum : Tipo.values()) {
            tipoCombobox.addItem(tipoEnum);
        }
    }
    public JButton getFiltrarPorTipo() {
        return filtrarPorTipo;
    }

    public void setFiltrarPorTipo(JButton filtrarPorTipo) {
        this.filtrarPorTipo = filtrarPorTipo;
    }
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


    public JComboBox<Tipo> getTipoCombobox() {
        return tipoCombobox;
    }

    public void setTipoCombobox(JComboBox<Tipo> tipoCombobox) {
        this.tipoCombobox = tipoCombobox;
    }
    public JButton getBotonSeleccionarPokemon() {
        return botonSeleccionarPokemon;
    }

    public void setBotonSeleccionarPokemon(JButton botonSeleccionarPokemon) {
        this.botonSeleccionarPokemon = botonSeleccionarPokemon;
    }


    public JButton getBotonActualizarPokemon() {
        return botonActualizarPokemon;
    }

    public void setBotonActualizarPokemon(JButton botonActualizarPokemon) {
        this.botonActualizarPokemon = botonActualizarPokemon;
    }

    public JButton getBotonVerListaPokemon() {
        return botonVerListaPokemon;
    }

    public void setBotonVerListaPokemon(JButton botonVerListaPokemon) {
        this.botonVerListaPokemon = botonVerListaPokemon;
    }

    public JButton getBotonCrearPokemon() {
        return botonCrearPokemon;
    }

    public void setBotonCrearPokemon(JButton botonCrearPokemon) {
        this.botonCrearPokemon = botonCrearPokemon;
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

    public JLabel getPokeAPILabel() {
        return pokeAPILabel;
    }

    public void setPokeAPILabel(JLabel pokeAPILabel) {
        this.pokeAPILabel = pokeAPILabel;
    }

    public JTextArea getAreadeTexto() {
        return areadeTexto;
    }

    public void setAreadeTexto(JTextArea areadeTexto) {
        this.areadeTexto = areadeTexto;
    }

    public JButton getBotonBorrarPokemon() {
        return botonBorrarPokemon;
    }

    public void setBotonBorrarPokemon(JButton botonBorrarPokemon) {
        this.botonBorrarPokemon = botonBorrarPokemon;
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



    //method to show an info alert
    public void alertar(String texto) {
        JOptionPane.showMessageDialog(rootPane, texto);
    }

}