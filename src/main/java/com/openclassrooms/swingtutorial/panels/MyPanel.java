package com.openclassrooms.swingtutorial.panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        System.out.println("Je suis exécutée !");
        int x1 = this.getWidth() / 4;
        int y1 = this.getHeight() / 4;
//        g.fillOval(x1, y1, this.getWidth() / 2, this.getHeight() / 2);
//        g.drawOval(x1, y1, this.getWidth() / 2, this.getHeight() / 2);
//        g.fillRect(x1, y1, this.getWidth() / 2, this.getHeight() / 2);
//        g.drawRect(x1, y1, this.getWidth() / 2, this.getHeight() / 2);
        g.drawRoundRect(x1, y1, this.getWidth() / 2, this.getHeight() / 2, this.getHeight() / 10, this.getHeight() / 10);
        int[] x = {20, 30, 50, 60, 60, 50, 30, 20};
        int[] y = {30, 20, 20, 30, 50, 60, 60, 50};
        g.drawPolygon(x, y, 8);

        int[] x2 = {50, 60, 80, 90, 90, 80, 60, 50};
        int[] y2 = {60, 50, 50, 60, 80, 90, 90, 80};
        g.fillPolygon(x2, y2, 8);
        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Tiens ! Le Site du Zéro !", 10, 20);
        try {
            Image img = ImageIO.read(new File("java.png"));
            //g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

    }
}
