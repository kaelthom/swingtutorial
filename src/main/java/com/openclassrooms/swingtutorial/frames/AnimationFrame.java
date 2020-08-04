package com.openclassrooms.swingtutorial.frames;

import com.openclassrooms.swingtutorial.panels.AnimationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationFrame extends JFrame {
    private AnimationPanel pan = new AnimationPanel();
    private JButton bouton = new JButton("mon bouton");
    private JButton bouton2 = new JButton("mon bouton 2");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Quelle belle animation");
    private boolean animated = true;

    public AnimationFrame() {
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        //Définition d'une police d'écriture
        Font police = new Font("Tahoma", Font.BOLD, 16);
        //On l'applique au JLabel
        label.setFont(police);
        //Changement de la couleur du texte
        label.setForeground(Color.blue);
        //On modifie l'alignement du texte grâce aux attributs statiques
        //de la classe JLabel
        label.setHorizontalAlignment(JLabel.CENTER);
        container.add(label, BorderLayout.NORTH);

        container.add(pan, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        //Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
        bouton.addActionListener(new Bouton1Listener());
        bottomPanel.add(bouton);
        bouton2.addActionListener(new Bouton2Listener());
        updateButtonEnabling();
        bottomPanel.add(bouton2);
        container.add(bottomPanel, BorderLayout.SOUTH);

        this.setContentPane(container);
        this.setVisible(true);
        go();
    }

    private void updateButtonEnabling() {
        bouton.setEnabled(!animated);
        bouton2.setEnabled(animated);
    }

    private void go() {
        //Les coordonnées de départ de notre rond
        int x = pan.getPosX(), y = pan.getPosY();
        //Le booléen pour savoir si l'on recule ou non sur l'axe x
        boolean backX = false;
        //Le booléen pour savoir si l'on recule ou non sur l'axe y
        boolean backY = false;

        //Dans cet exemple, j'utilise une boucle while
        //Vous verrez qu'elle fonctionne très bien
        while (animated) {
            //Si la coordonnée x est inférieure à 1, on avance
            if (x < 1) backX = false;
            //Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
            if (x > pan.getWidth() - 50) backX = true;
            //Idem pour l'axe y
            if (y < 1) backY = false;
            if (y > pan.getHeight() - 50) backY = true;

            //Si on avance, on incrémente la coordonnée
            if (!backX)
                pan.setPosX(++x);
                //Sinon, on décrémente
            else
                pan.setPosX(--x);
            //Idem pour l'axe Y
            if (!backY)
                pan.setPosY(++y);
            else
                pan.setPosY(--y);

            //On redessine notre Panneau
            pan.repaint();
            //Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class Bouton1Listener implements ActionListener {
        private int compteur = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            compteur++;
            animated = true;
            updateButtonEnabling();
            label.setText("Vous avez cliqué " + this.compteur + " fois sur le bouton 1 et commencé l'animation");
            new Thread(new PlayAnimation()).start();
        }
    }

    class Bouton2Listener implements ActionListener {
        private int compteur2 = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            compteur2++;
            animated = false;
            updateButtonEnabling();
            label.setText("Vous avez cliqué " + this.compteur2 + " fois sur le bouton 2 et stoppé l'animation");
        }
    }

    class PlayAnimation implements Runnable {
        public void run() {
            go();
        }
    }
}
