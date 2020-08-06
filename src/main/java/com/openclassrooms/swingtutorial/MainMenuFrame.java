package com.openclassrooms.swingtutorial;

import javax.swing.*;

public class MainMenuFrame extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test1_2 = new JMenu("Sous ficher");
    private JMenu test2 = new JMenu("Edition");

    private JMenuItem item1 = new JMenuItem("Ouvrir");
    private JMenuItem item2 = new JMenuItem("Fermer");
    private JMenuItem item3 = new JMenuItem("Lancer");
    private JMenuItem item4 = new JMenuItem("Arrêter");

    private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
    private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");

    private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
    private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");

    public MainMenuFrame() {
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On initialise nos menus
        this.test1.add(item1);

        //On ajoute les éléments dans notre sous-menu
        this.test1_2.add(jcmi1);
        this.test1_2.add(jcmi2);
        //Ajout d'un séparateur
        this.test1_2.addSeparator();
        //On met nos radios dans un ButtonGroup
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrmi1);
        bg.add(jrmi1);
        //On présélectionne la première radio
        jrmi1.setSelected(true);

        this.test1_2.add(jrmi1);
        this.test1_2.add(jrmi2);

        //Ajout du sous-menu dans notre menu
        this.test1.add(this.test1_2);
        //Ajout d'un séparateur
        this.test1.addSeparator();
        item2.addActionListener(arg0 -> System.exit(0));
        this.test1.add(item2);
        this.test2.add(item3);
        this.test2.add(item4);

        //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
        //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
        this.menuBar.add(test1);
        this.menuBar.add(test2);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainMenuFrame zFen = new MainMenuFrame();
    }
}
