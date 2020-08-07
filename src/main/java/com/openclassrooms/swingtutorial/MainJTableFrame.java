package com.openclassrooms.swingtutorial;

import javax.swing.*;

//CTRL + SHIFT + O pour générer les imports
public class MainJTableFrame extends JFrame {

    public MainJTableFrame() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(300, 120);

        //Les données du tableau
        Object[][] data = {
                {"Cysboy", "28 ans", "1.80 m"},
                {"BZHHydde", "28 ans", "1.80 m"},
                {"IamBow", "24 ans", "1.90 m"},
                {"FunMan", "32 ans", "1.85 m"}
        };

        //Les titres des colonnes
        String title[] = {"Pseudo", "Age", "Taille"};
        JTable tableau = new JTable(data, title);

        /* sans scroll besoin de préciser la position du header
        //On indique que l'en-tête doit être au nord, donc au-dessus
        this.getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        //Et le corps au centre !
        this.getContentPane().add(tableau, BorderLayout.CENTER);*/

        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.getContentPane().add(new JScrollPane(tableau));
    }

    public static void main(String[] args) {
        MainJTableFrame fen = new MainJTableFrame();
        fen.setVisible(true);
    }
}
