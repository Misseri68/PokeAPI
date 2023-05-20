package org.infantaelena.vista;
import javax.swing.*;
import java.awt.*;

public class PokemonView extends JFrame {
    private JLabel ataqueLabel;
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