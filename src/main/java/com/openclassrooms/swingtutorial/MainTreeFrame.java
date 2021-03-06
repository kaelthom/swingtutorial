package com.openclassrooms.swingtutorial;

//CTRL + SHIFT + O pour générer les imports nécessaires

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainTreeFrame extends JFrame {
    private JTree arbre;

    public MainTreeFrame() {
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Les arbres");
        //On invoque la méthode de construction de notre arbre
        buildTree();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainTreeFrame fen = new MainTreeFrame();
    }

    private void buildTree() {
        //Création d'une racine
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Racine");

        //Nous allons ajouter des branches et des feuilles à notre racine
        for (int i = 1; i < 12; i++) {
            DefaultMutableTreeNode rep = new DefaultMutableTreeNode("Noeud n°" + i);

            //S'il s'agit d'un nombre pair, on rajoute une branche
            if ((i % 2) == 0) {
                //Et une branche en plus ! Une !
                for (int j = 1; j < 5; j++) {
                    DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode("Fichier enfant n°" + j);
                    //Cette fois, on ajoute les feuilles
                    for (int k = 1; k < 5; k++)
                        rep2.add(new DefaultMutableTreeNode("Sous-fichier enfant n°" + k));
                    rep.add(rep2);
                }
            }
            //On ajoute la feuille ou la branche à la racine
            racine.add(rep);
        }
        //Nous créons, avec notre hiérarchie, un arbre
        arbre = new JTree(racine);

        //Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un scroll
        this.getContentPane().add(new JScrollPane(arbre));
    }
}
