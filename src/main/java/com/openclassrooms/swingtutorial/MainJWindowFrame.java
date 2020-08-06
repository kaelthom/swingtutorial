package com.openclassrooms.swingtutorial;

//CTRL + SHIFT + O pour générer les imports nécessaires

import javax.swing.*;
import java.awt.*;

public class MainJWindowFrame extends JWindow {

    public MainJWindowFrame() {
        setSize(220, 165);
        setLocationRelativeTo(null);
        JPanel pan = new JPanel();
        JLabel img = new JLabel(new ImageIcon("planète.jpeg"));
        img.setVerticalAlignment(JLabel.CENTER);
        img.setHorizontalAlignment(JLabel.CENTER);
        pan.setBorder(BorderFactory.createLineBorder(Color.blue));
        pan.add(img);
        getContentPane().add(pan);
    }

    public static void main(String[] args) {
        MainJWindowFrame wind = new MainJWindowFrame();
        wind.setVisible(true);
    }
}
