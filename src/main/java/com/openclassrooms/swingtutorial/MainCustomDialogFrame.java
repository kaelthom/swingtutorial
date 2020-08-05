package com.openclassrooms.swingtutorial;

import com.openclassrooms.swingtutorial.dialogs.CustomDialog;
import com.openclassrooms.swingtutorial.dialogs.CustomDialogInfo;

import javax.swing.*;
import java.awt.*;

public class MainCustomDialogFrame extends JFrame {
    private JButton bouton = new JButton("Appel à la ZDialog");

    public MainCustomDialogFrame() {
        this.setTitle("Ma JFrame");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(bouton);
        bouton.addActionListener(arg0 -> {
            CustomDialog zd = new CustomDialog(null, "Coucou les ZérOs", true);
            CustomDialogInfo zInfo = zd.showZDialog();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, zInfo.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
        });
        this.setVisible(true);
    }

    public static void main(String[] main) {
        MainCustomDialogFrame fen = new MainCustomDialogFrame();
    }
}
