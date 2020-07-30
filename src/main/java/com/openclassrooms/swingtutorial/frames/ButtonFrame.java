package com.openclassrooms.swingtutorial.frames;

import javax.swing.*;

public class ButtonFrame extends JFrame {
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Mon bouton");

    public ButtonFrame() {
        this.setTitle("Animation");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //Ajout du bouton à notre content pane
        pan.add(bouton);
        this.setContentPane(pan);
        this.setVisible(true);
    }
}
