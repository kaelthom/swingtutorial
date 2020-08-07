package com.openclassrooms.swingtutorial;

import com.openclassrooms.swingtutorial.panels.DetailsTreeFilePanel;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;

public class MainTreeFrameWithDetails extends JFrame {

    private JTree arbre;
    private DefaultMutableTreeNode racine;
    private DetailsTreeFilePanel panneau = new DetailsTreeFilePanel();
    //On va créer deux modèles d'affichage
    private DefaultTreeCellRenderer[] tCellRenderer = new DefaultTreeCellRenderer[3];

    public MainTreeFrameWithDetails() {
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Les arbres");
        //On invoque la méthode de construction de notre arbre
        initRenderer();
        listRoot();
        try {
            //On force à utiliser le « look and feel » du système
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //Ici on force tous les composants de notre fenêtre (this) à se redessiner avec le « look and feel » du système
            SwingUtilities.updateComponentTreeUI(this);
        } catch (InstantiationException | ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException e) {
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainTreeFrameWithDetails();
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

            //Si nous avons parcouru plus de 50 dossiers, on sort
            //if(count > 50) {break;}

        }
        //On crée, avec notre hiérarchie, un arbre
        arbre = new JTree(this.racine);
        arbre.setRootVisible(false);
        //On définit le rendu pour cet arbre
        arbre.setCellRenderer(this.tCellRenderer[0]);
        arbre.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent event) {
                if (arbre.getLastSelectedPathComponent() != null) {
                    //La méthode getPath retourne un objet TreePath
                    File file = new File(getAbsolutePath(event.getPath()));
                    panneau.setTexte(getDescription(file));
                }
            }

            private String getAbsolutePath(TreePath treePath) {
                String str = "";
                //On balaie le contenu de notre TreePath
                for (Object name : treePath.getPath()) {
                    //Si l'objet à un nom, on l'ajoute au chemin
                    if (name.toString() != null)
                        str += name.toString();
                }
                return str;
            }

            /**
             * Retourne une description d'un objet File
             * @param file
             * @return
             */
            private String getDescription(File file) {
                String str = "Chemin d'accès sur le disque : \n\t" + file.getAbsolutePath() + "\n";
                str += (file.isFile()) ? "Je suis un fichier.\nJe fais " + file.length() + " ko\n" : "Je suis un dossier.\n";
                str += "J'ai des droits : \n";
                str += "\t en lecture : " + ((file.canRead()) ? "Oui;" : "Non;");
                str += "\n\t en écriture : " + ((file.canWrite()) ? "Oui;" : "Non;");
                return str;
            }
        });
        //On crée un séparateur de conteneur pour réviser
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(arbre), new JScrollPane(panneau));
        //On place le séparateur
        split.setDividerLocation(200);
        //On ajoute le tout
        this.getContentPane().add(split, BorderLayout.CENTER);
    }

    private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node) {
        int count = 0;

        if (file.isFile())
            return new DefaultMutableTreeNode(file.getName());
        else {
            File[] list = file.listFiles();
            if (list == null)
                return new DefaultMutableTreeNode(file.getName());
            for (File nom : file.listFiles()) {
                count++;
                //Pas plus de 5 enfants par nœud
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
