package com.openclassrooms.swingtutorial;

import javax.swing.*;
import java.awt.*;

//CTRL + SHIFT + O pour générer les imports nécessaires
public class MainSlide extends JFrame {
    private JLabel label = new JLabel("Valeur actuelle : 30");

    public MainSlide() {
        this.setSize(250, 150);
        this.setTitle("Slider");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSlider slide = new JSlider();

        slide.setMaximum(100);
        slide.setMinimum(0);
        slide.setValue(30);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setMinorTickSpacing(10);
        slide.setMajorTickSpacing(20);
        slide.addChangeListener(event -> label.setText("Valeur actuelle : " + ((JSlider) event.getSource()).getValue()));
        this.getContentPane().add(slide, BorderLayout.CENTER);
        this.getContentPane().add(label, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        MainSlide mainSlide = new MainSlide();
        mainSlide.setVisible(true);
    }
}
