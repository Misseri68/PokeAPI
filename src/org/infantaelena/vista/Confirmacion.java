package org.infantaelena.vista;

import javax.swing.*;

public class Confirmacion extends JFrame {
    private JPanel confirmacionJPanel;
    private JButton sibutton;
    private JButton noButton;
    private JLabel eliminarJLabel;
    private JLabel preguntaJlabel;

    public Confirmacion( ) {
        super("pokeAPI");
        confirmacionJPanel = new JPanel();  // Inicializo el JPanel
        setContentPane(confirmacionJPanel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Initialize the JButton components
        sibutton = new JButton("Sí");
        noButton = new JButton("No");

        // Initialize the JLabel components
        eliminarJLabel = new JLabel("Vas a eliminar el pokemon,");
        preguntaJlabel = new JLabel("¿Estás seguro?");

        confirmacionJPanel.add(eliminarJLabel);
        confirmacionJPanel.add(preguntaJlabel);
        confirmacionJPanel.add(sibutton);
        confirmacionJPanel.add(noButton);
    }
    public JPanel getConfirmacionJPanel() {
        return confirmacionJPanel;
    }

    public void setConfirmacionJPanel(JPanel confirmacionJPanel) {
        this.confirmacionJPanel = confirmacionJPanel;
    }

    public JButton getSibutton() {
        return sibutton;
    }

    public void setSibutton(JButton sibutton) {
        this.sibutton = sibutton;
    }

    public JButton getNoButton() {
        return noButton;
    }

    public void setNoButton(JButton noButton) {
        this.noButton = noButton;
    }

    public JLabel getEliminarJLabel() {
        return eliminarJLabel;
    }

    public void setEliminarJLabel(JLabel eliminarJLabel) {
        this.eliminarJLabel = eliminarJLabel;
    }

    public JLabel getPreguntaJlabel() {
        return preguntaJlabel;
    }

    public void setPreguntaJlabel(JLabel preguntaJlabel) {
        this.preguntaJlabel = preguntaJlabel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
package org.infantaelena.vista;

import org.infantaelena.modelo.entidades.Tipo;

import javax.swing.*;

public class Confirmacion extends JFrame {
    private JPanel confirmacionJlabel;
    private JButton sibutton;
    private JButton noButton;
    private JLabel eliminarJLabel;
    private JLabel preguntaJlabel;

    public Confirmacion( ) {
        super("confirmacion");
        setContentPane(confirmacionJlabel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public JPanel getConfirmacionJlabel() {
        return confirmacionJlabel;
    }

    public void setConfirmacionJlabel(JPanel confirmacionJlabel) {
        this.confirmacionJlabel = confirmacionJlabel;
    }

    public JButton getSibutton() {
        return sibutton;
    }

    public void setSibutton(JButton sibutton) {
        this.sibutton = sibutton;
    }

    public JButton getNoButton() {
        return noButton;
    }

    public void setNoButton(JButton noButton) {
        this.noButton = noButton;
    }

    public JLabel getEliminarJLabel() {
        return eliminarJLabel;
    }

    public void setEliminarJLabel(JLabel eliminarJLabel) {
        this.eliminarJLabel = eliminarJLabel;
    }

    public JLabel getPreguntaJlabel() {
        return preguntaJlabel;
    }

    public void setPreguntaJlabel(JLabel preguntaJlabel) {
        this.preguntaJlabel = preguntaJlabel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
