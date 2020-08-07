package com.openclassrooms.swingtutorial;

//CTRL + SHIFT + O pour générer les imports nécessaires

import javax.swing.*;
import java.awt.*;

public class MainDesktopFrame extends JFrame {
    private static int nbreFenetre = 0;
    private static int xy = 10;
    private JDesktopPane desktop = new JDesktopPane();

    public MainDesktopFrame() {
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton ajouter = new JButton("Ajouter une fenêtre interne");
        ajouter.addActionListener(event -> {
            ++nbreFenetre;
            xy += 2;
            desktop.add(new MiniFenetre(nbreFenetre), nbreFenetre);
        });

        this.getContentPane().add(desktop, BorderLayout.CENTER);
        this.getContentPane().add(ajouter, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        MainDesktopFrame bureau = new MainDesktopFrame();
        bureau.setVisible(true);
    }

    class MiniFenetre extends JInternalFrame {
        public MiniFenetre(int nbre) {
            this.setTitle("MainTreeFrame N°" + nbre);
            this.setClosable(true);
            this.setResizable(true);
            this.setSize(150, 80);
            this.setLocation(xy, xy);
            this.setVisible(true);
        }
    }
}
