package com.openclassrooms.swingtutorial;

import javax.swing.*;
import java.awt.*;

//CTRL + SHIFT + O pour générer les imports nécessaires
public class MainProgressBarFrame extends JFrame {
    private Thread t;
    private JProgressBar bar;
    private JButton launch;

    public MainProgressBarFrame() {
        this.setSize(300, 80);
        this.setTitle("*** JProgressBar ***");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        t = new Thread(new Traitement());
        bar = new JProgressBar();
        bar.setMaximum(500);
        bar.setMinimum(0);
        bar.setStringPainted(true);

        this.getContentPane().add(bar, BorderLayout.CENTER);

        launch = new JButton("Lancer");
        launch.addActionListener(event -> {
            t = new Thread(new Traitement());
            t.start();
        });
        this.getContentPane().add(launch, BorderLayout.SOUTH);
        t.start();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainProgressBarFrame();
    }

    class Traitement implements Runnable {
        public void run() {
            launch.setEnabled(false);

            for (int val = 0; val <= 500; val++) {
                bar.setValue(val);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            launch.setEnabled(true);
        }
    }
}
