package com.openclassrooms.swingtutorial;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

//CTRL + SHIFT + O pour générer les imports nécessaires
public class MainTreeFrameRoot extends JFrame {
    private JTree arbre;
    private DefaultMutableTreeNode racine;

    public MainTreeFrameRoot() {
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Les arbres");
        //On invoque la méthode de construction de l'arbre
        listRoot();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainTreeFrameRoot fen = new MainTreeFrameRoot();
    }

    private void listRoot() {
        this.racine = new DefaultMutableTreeNode();
        int count = 0;
        for (File file : File.listRoots()) {
            DefaultMutableTreeNode lecteur =
                    new DefaultMutableTreeNode(file.getAbsolutePath());
            try {
                for (File nom : file.listFiles()) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom.getName() + "\\");
                    lecteur.add(this.listFile(nom, node));
                }
            } catch (NullPointerException e) {
            }

            this.racine.add(lecteur);
        }
        //Nous créons, avec notre hiérarchie, un arbre
        arbre = new JTree(this.racine);
        //Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un scroll
        this.getContentPane().add(new JScrollPane(arbre));
    }

    private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node) {
        int count = 0;

        if (file.isFile())
            return new DefaultMutableTreeNode(file.getName());
        else {
            File[] list = file.listFiles();
            if (list == null)
                return new DefaultMutableTreeNode(file.getName());

            for (File nom : list) {
                count++;
                //Pas plus de 5 enfants par noeud
                if (count < 5) {
                    DefaultMutableTreeNode subNode;
                    if (nom.isDirectory()) {
                        subNode = new DefaultMutableTreeNode(nom.getName() + "\\");
                        node.add(this.listFile(nom, subNode));
                    } else {
                        subNode = new DefaultMutableTreeNode(nom.getName());
                    }
                    node.add(subNode);
                }
            }
            return node;
        }
    }
}
