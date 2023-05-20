package org.infantaelena;

import org.infantaelena.controlador.Controlador;
import org.infantaelena.vista.PokemonView;
import org.infantaelena.vista.Vista;

import javax.swing.*;

public class Main

{

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