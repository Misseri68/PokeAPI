package org.infantaelena;
import org.infantaelena.vista.Vista;
import javax.swing.*;

public class Main

{

    public static void main(String args[]) {

        Vista vista = new Vista();
        vista.alertar("Hello PokeWorld!");

        /*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Vista();
                frame.setSize(800, 600);
                frame.setVisible(true);
            }
        });*/
  

    }

}