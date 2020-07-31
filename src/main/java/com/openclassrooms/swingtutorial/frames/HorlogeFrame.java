package com.openclassrooms.swingtutorial.frames;

import com.openclassrooms.swingtutorial.components.Horloge;

import javax.swing.*;
import java.awt.*;

public class HorlogeFrame extends JFrame {
    private JLabel label = new JLabel();
    private Horloge horloge;

    public HorlogeFrame() {
        //On initialise la JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(200, 80);

        //On initialise l'horloge
        this.horloge = new Horloge();
        //On place un écouteur sur l'horloge
        this.horloge.addObservateur(hour -> label.setText(hour));
        //On initialise le JLabel
        Font police = new Font("Arial", Font.TYPE1_FONT, 30);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        //On ajoute le JLabel à la JFrame
        this.getContentPane().add(this.label, BorderLayout.CENTER);
        this.setVisible(true);
        this.horloge.run();
    }

}
