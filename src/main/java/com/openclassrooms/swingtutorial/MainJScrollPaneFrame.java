package com.openclassrooms.swingtutorial;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

public class MainJScrollPaneFrame extends JFrame {

    private JTextArea textPane = new JTextArea();
    private JScrollPane scroll = new JScrollPane(textPane);

    public MainJScrollPaneFrame() {
        this.setLocationRelativeTo(null);
        this.setTitle("Gérer vos conteneur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 200);

        JButton bouton = new JButton("Bouton");
        bouton.addActionListener(e -> {
            System.out.println("Texte écrit dans le JTextArea : ");
            System.out.println("--------------------------------");
            System.out.println(textPane.getText());
        });

        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        //On ajoute l'objet au content pane de notre fenêtre
        this.getContentPane().add(scroll, BorderLayout.CENTER);
        //On aurait pu aussi écrire
        //this.getContentPane().add(new JScrollPane(textPane), BorderLayout.CENTER);
        this.getContentPane().add(bouton, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainJScrollPaneFrame();
    }
}
