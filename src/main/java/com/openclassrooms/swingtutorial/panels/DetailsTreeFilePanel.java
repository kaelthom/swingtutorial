package com.openclassrooms.swingtutorial.panels;

import javax.swing.*;
import java.awt.*;

public class DetailsTreeFilePanel extends JPanel {
    private String texte = "Racine de l'arbre.";
    private JTextArea jta;

    public DetailsTreeFilePanel() {
        this.jta = new JTextArea(texte);
        this.setBackground(Color.white);
        this.add(jta);
    }

    public void setTexte(String texte) {
        this.jta.setText(texte);
    }
}
