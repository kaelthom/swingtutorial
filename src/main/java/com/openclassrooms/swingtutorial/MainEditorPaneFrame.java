package com.openclassrooms.swingtutorial;

//CTRL + SHIFT + O pour générer les imports nécessaires

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MainEditorPaneFrame extends JFrame {
    private JEditorPane editorPane, apercu;
    private JTabbedPane onglet = new JTabbedPane();

    public MainEditorPaneFrame() {
        this.setSize(600, 400);
        this.setTitle("Conteneur éditable");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        editorPane = new JEditorPane();
        editorPane.setText(" <HTML><HEAD></HEAD><BODY></BODY></HTML> ");

        apercu = new JEditorPane();
        apercu.setEditable(false);

        onglet.addTab("Editeur HTML", new JScrollPane(editorPane));
        onglet.addTab("Aperçu", new JScrollPane(apercu));
        onglet.addChangeListener(e -> {
            FileWriter fw = null;
            try {
                fw = new FileWriter(new File("tmp/tmp.html"));
                fw.write(editorPane.getText());
                fw.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                File file = new File("tmp/tmp.html");
                apercu.setEditorKit(new HTMLEditorKit());
                apercu.setPage(file.toURL());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        this.getContentPane().add(onglet, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainEditorPaneFrame fen = new MainEditorPaneFrame();
    }
}
