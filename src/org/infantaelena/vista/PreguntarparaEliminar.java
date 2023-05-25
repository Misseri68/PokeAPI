package org.infantaelena.vista;

import javax.swing.*;

public class PreguntarparaEliminar extends JFrame {
    private JPanel panel1;
    private JLabel aviso;
    private JLabel pregunta;
    private JButton NOButton;



    private JButton SIButton;

    public PreguntarparaEliminar(){
        super("pregunta");
        setContentPane(panel1);
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JButton getNOButton() {
        return NOButton;
    }

    public JButton getSIButton() {
        return SIButton;
    }

}
