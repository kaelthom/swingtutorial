package com.openclassrooms.swingtutorial;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CTRL + SHIFT + O pour générer les imports
public class MainJTableFrameSizeChange extends JFrame {

    private JTable tableau;
    private JButton change = new JButton("Changer la taille");
    private JButton retablir = new JButton("Rétablir");

    public MainJTableFrameSizeChange() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(300, 240);

        Object[][] data = {
                {"Cysboy", "28 ans", "1.80 m"},
                {"BZHHydde", "28 ans", "1.80 m"},
                {"IamBow", "24 ans", "1.90 m"},
                {"FunMan", "32 ans", "1.85 m"}
        };

        String title[] = {"Pseudo", "Age", "Taille"};
        this.tableau = new JTable(data, title);

        JPanel pan = new JPanel();

        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                changeSize(200, 80);
                change.setEnabled(false);
                retablir.setEnabled(true);
            }
        });

        retablir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                changeSize(75, 16);
                change.setEnabled(true);
                retablir.setEnabled(false);
            }
        });

        retablir.setEnabled(false);
        pan.add(change);
        pan.add(retablir);

        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        this.getContentPane().add(pan, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        MainJTableFrameSizeChange fen = new MainJTableFrameSizeChange();
        fen.setVisible(true);
    }

    /**
     * Change la taille d'une ligne et d'une colonne
     * J'ai mis deux boucles afin que vous puissiez voir
     * comment parcourir les colonnes et les lignes
     */
    public void changeSize(int width, int height) {
        //Nous créons un objet TableColumn afin de travailler sur notre colonne
        TableColumn col;
        for (int i = 0; i < tableau.getColumnCount(); i++) {
            if (i == 1) {
                //On récupère le modèle de la colonne
                col = tableau.getColumnModel().getColumn(i);
                //On lui affecte la nouvelle valeur
                col.setPreferredWidth(width);
            }
        }
        for (int i = 0; i < tableau.getRowCount(); i++) {
            //On affecte la taille de la ligne à l'indice spécifié !
            if (i == 1)
                tableau.setRowHeight(i, height);
        }
    }
}
