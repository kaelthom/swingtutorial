package com.openclassrooms.swingtutorial.frames;

import com.openclassrooms.swingtutorial.panels.MyPanel;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        JFrame fenetre = new JFrame();
        //Définit un titre pour notre fenêtre
        this.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 100 pixels de large et 150 pixels de haut
        this.setSize(100, 150);
        //Nous demandons maintenant à notre objet de se positionner au centre
        this.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(new MyPanel());
        //Et enfin, la rendre visible
        this.setVisible(true);
    }
}
