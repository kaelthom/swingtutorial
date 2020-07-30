package com.openclassrooms.swingtutorial.frames;

import javax.swing.*;

public class ButtonFrame extends JFrame {
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Mon bouton");

    public ButtonFrame() {
        this.setTitle("Box Layout");
        this.setSize(300, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel b1 = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(new JButton("Bouton 1"));

        JPanel b2 = new JPanel();
        //Idem pour cette ligne
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(new JButton("Bouton 2"));
        b2.add(new JButton("Bouton 3"));

        JPanel b3 = new JPanel();
        //Idem pour cette ligne
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(new JButton("Bouton 4"));
        b3.add(new JButton("Bouton 5"));
        b3.add(new JButton("Bouton 6"));

        JPanel b4 = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        this.getContentPane().add(b4);
        this.setVisible(true);
    }
}
