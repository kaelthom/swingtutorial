package com.openclassrooms.swingtutorial;

import javax.swing.*;

public class MainDialogFrame {
    public static void main(String[] args) {
        JOptionPane jop, jop2, jop3;
        jop = new JOptionPane();
        ImageIcon img = new ImageIcon("images/information.png");
        jop.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);
        jop2 = new JOptionPane();
        img = new ImageIcon("images/warning.png");
        jop2.showMessageDialog(null, "Message préventif", "Attention", JOptionPane.WARNING_MESSAGE);
        jop3 = new JOptionPane();
        img = new ImageIcon("images/erreur.png");
        jop3.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
        jop = new JOptionPane();
        jop2 = new JOptionPane();
        String nom = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Gendarmerie nationale !", JOptionPane.QUESTION_MESSAGE);
        jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
        String[] sexe = {"masculin", "féminin", "indéterminé"};
        jop = new JOptionPane();
        jop2 = new JOptionPane();
        String sexeChosen = (String) jop.showInputDialog(null,
                "Veuillez indiquer votre sexe !",
                "Gendarmerie nationale !",
                JOptionPane.QUESTION_MESSAGE,
                null,
                sexe,
                sexe[2]);
        jop2.showMessageDialog(null, "Votre sexe est " + sexeChosen, "Etat civil", JOptionPane.INFORMATION_MESSAGE);
        jop = new JOptionPane();
        jop2 = new JOptionPane();
        int rang = jop.showOptionDialog(null,
                "Veuillez indiquer votre sexe !",
                "Gendarmerie nationale !",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                sexe,
                sexe[2]);
        jop2.showMessageDialog(null, "Votre sexe est " + sexe[rang], "Etat civil", JOptionPane.INFORMATION_MESSAGE);
    }
}
