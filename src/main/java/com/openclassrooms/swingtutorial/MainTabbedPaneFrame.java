package com.openclassrooms.swingtutorial;

import com.openclassrooms.swingtutorial.panels.TabbedPanePanel;

import javax.swing.*;
import java.awt.*;

public class MainTabbedPaneFrame extends JFrame {
    private JTabbedPane onglet;

    public MainTabbedPaneFrame() {
        this.setLocationRelativeTo(null);
        this.setTitle("Gérer vos conteneurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        //Création de plusieurs Panneau
        TabbedPanePanel[] tPan = {new TabbedPanePanel(Color.RED), new TabbedPanePanel(Color.GREEN), new TabbedPanePanel(Color.BLUE)};

        //Création de notre conteneur d'onglets
        onglet = new JTabbedPane();
        onglet.setTabPlacement(JTabbedPane.RIGHT); // or in constructor
        int i = 0;
        for (TabbedPanePanel pan : tPan) {
            //Méthode d'ajout d'onglet
            onglet.add("Onglet n° " + (++i), pan);
            //Vous pouvez aussi utiliser la méthode addTab
            //onglet.addTab("Onglet n° "+(++i), pan);

        }
        //On passe ensuite les onglets au content pane
        this.getContentPane().add(onglet);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainTabbedPaneFrame();
    }
}
