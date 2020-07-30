package com.openclassrooms.swingtutorial.frames;

import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame {
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Mon bouton");

    public ButtonFrame() {
        this.setTitle("Bouton avec BorderLayout");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //On ajoute le bouton au content pane de la JFrame
        //Au centre
        this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
        //Au nord
        this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
        //Au sud
        this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
        //À l'ouest
        this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
        //À l'est
        this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
        this.setVisible(true);
    }
}
