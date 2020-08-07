package com.openclassrooms.swingtutorial;//CTRL + SHIFT + O pour générer les imports nécessaires

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.io.File;

public class MainLookAndFeelTreeFrame extends JFrame {
    private JTree arbre, arbre2, arbre3;
    private DefaultMutableTreeNode racine;
    //On va créer deux modèles d'affichage
    private DefaultTreeCellRenderer[] tCellRenderer = new DefaultTreeCellRenderer[3];

    public MainLookAndFeelTreeFrame(String lookAndFeel) {
        this.setSize(200, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String title = (lookAndFeel.split("\\."))[(lookAndFeel.split("\\.").length - 1)];
        this.setTitle("Nom du look and feel : " + title);

        listRoot();
        //On force l'utilisation
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (InstantiationException e) {
        } catch (ClassNotFoundException e) {
        } catch (UnsupportedLookAndFeelException e) {
        } catch (IllegalAccessException e) {
        }

        this.setVisible(true);
    }


    public static void main(String[] args) {
        //Nous allons créer des fenêtres avec des looks différents
        //Cette instruction permet de récupérer tous les looks du système
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        MainLookAndFeelTreeFrame fen;
        //On parcourt tout le tableau en passant le nom du look à utiliser
        for (int i = 0; i < looks.length; i++)
            fen = new MainLookAndFeelTreeFrame(looks[i].getClassName());
    }

    private void initRenderer() {
        //Instanciation
        this.tCellRenderer[0] = new DefaultTreeCellRenderer();
        //Initialisation des images pour les actions fermer, ouvrir et pour les feuilles
        this.tCellRenderer[0].setClosedIcon(new ImageIcon("img/ferme.jpg"));
        this.tCellRenderer[0].setOpenIcon(new ImageIcon("img/ouvert.jpg"));
        this.tCellRenderer[0].setLeafIcon(new ImageIcon("img/feuille.jpg"));

        this.tCellRenderer[1] = new DefaultTreeCellRenderer();
        this.tCellRenderer[1].setClosedIcon(null);
        this.tCellRenderer[1].setOpenIcon(null);
        this.tCellRenderer[1].setLeafIcon(null);
    }

    private void listRoot() {
        this.racine = new DefaultMutableTreeNode();
        int count = 0;
        for (File file : File.listRoots()) {
            DefaultMutableTreeNode lecteur = new DefaultMutableTreeNode(file.getAbsolutePath());
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
        arbre.setRootVisible(false);
        //On définit le rendu pour cet arbre
        arbre.setCellRenderer(this.tCellRenderer[0]);

        arbre2 = new JTree(this.racine);
        arbre2.setRootVisible(false);
        arbre2.setCellRenderer(this.tCellRenderer[1]);

        arbre3 = new JTree(this.racine);
        arbre3.setRootVisible(false);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(arbre2),
                new JScrollPane(arbre3));
        split.setDividerLocation(200);

        JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(arbre),
                split);
        split2.setDividerLocation(200);
        this.getContentPane().add(split2);
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
