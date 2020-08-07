package com.openclassrooms.swingtutorial;

//CTRL + SHIFT + O pour générer les imports nécessaires

import com.openclassrooms.swingtutorial.panels.TabbedPanePanel;

import javax.swing.*;
import java.awt.*;

public class MainTabbedPanedDynamicFrame extends JFrame {
    private JTabbedPane onglet;
    //Compteur pour le nombre d'onglets
    private int nbreTab = 0;

    public MainTabbedPanedDynamicFrame() {
        this.setLocationRelativeTo(null);
        this.setTitle("Gérer vos conteneurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        //Création de plusieurs Panneau
        TabbedPanePanel[] tPan = {new TabbedPanePanel(Color.RED), new TabbedPanePanel(Color.GREEN), new TabbedPanePanel(Color.BLUE)};

        //Création de notre conteneur d'onglets
        onglet = new JTabbedPane();
        for (TabbedPanePanel pan : tPan) {
            //Méthode d'ajout d'onglets
            onglet.addTab("Onglet N°" + (++nbreTab), pan);
        }
        //On passe ensuite les onglets au content pane
        this.getContentPane().add(onglet, BorderLayout.CENTER);

        //Ajout du bouton pour ajouter des onglets
        JButton nouveau = new JButton("Ajouter un onglet");
        nouveau.addActionListener(e -> onglet.add("Onglet N°" + (++nbreTab), new TabbedPanePanel(Color.DARK_GRAY)));

        //Ajout du bouton pour retirer l'onglet sélectionné
        JButton delete = new JButton("Effacer l'onglet");
        delete.addActionListener(e -> {
            //On récupère l'index de l'onglet sélectionné
            int selected = onglet.getSelectedIndex();
            //S'il n'y a plus d'onglet, la méthode ci-dessus retourne -1
            if (selected > -1) onglet.remove(selected);
        });

        JPanel pan = new JPanel();
        pan.add(nouveau);
        pan.add(delete);

        this.getContentPane().add(pan, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainTabbedPanedDynamicFrame();
    }
}
