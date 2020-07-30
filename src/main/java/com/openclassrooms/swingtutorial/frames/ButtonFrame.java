package com.openclassrooms.swingtutorial.frames;

import javax.swing.*;

public class ButtonFrame extends JFrame {
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Mon bouton");

    public ButtonFrame() {
        this.setTitle("Bouton");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(bouton);
        this.setVisible(true);
    }
}
