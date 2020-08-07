package com.openclassrooms.swingtutorial;

import javax.swing.*;
import java.awt.*;

public class MainSplitPane extends JFrame {
    //On déclare notre objet JSplitPane
    private JSplitPane split;

    public MainSplitPane() {
        this.setLocationRelativeTo(null);
        this.setTitle("Gérer vos conteneur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 200);

        //On crée deux conteneurs de couleurs différentes
        JPanel pan = new JPanel();
        pan.setBackground(Color.blue);

        JPanel pan2 = new JPanel();
        pan2.setBackground(Color.red);

        //On construit enfin notre séparateur
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan, pan2);
        split.setOneTouchExpandable(true);
        split.setDividerSize(25);
        split.setDividerLocation(0.7);

        //On le passe ensuite au content pane de notre objet MainTabbedPanedDynamicFrame
        //placé au centre pour qu'il utilise tout l'espace disponible
        this.getContentPane().add(split, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainSplitPane fen = new MainSplitPane();
    }
}
