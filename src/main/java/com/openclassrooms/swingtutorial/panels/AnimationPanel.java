package com.openclassrooms.swingtutorial.panels;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
    private String form;
    private int posX = -50;
    private int posY = -50;

    public AnimationPanel() {
        this.form = "Circle";
    }

    public void paintComponent(Graphics g) {
        //On choisit une couleur de fond pour le rectangle
        g.setColor(Color.white);
        //On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.red);
        switch (form) {
            case "Circle":
                g.fillOval(posX, posY, 50, 50);
                break;
            case "Rectangle":
                g.fillRect(posX, posY, 50, 50);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + form);
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
