package com.openclassrooms.swingtutorial;

import com.openclassrooms.swingtutorial.celleditors.CellButtonEditor;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

//CTRL + SHIFT + O pour générer les imports
public class MainJTableFrameCustom extends JFrame {

    private JTable tableau;
    private JButton change = new JButton("Changer la taille");
    //Contenu de notre combo
    private String[] comboData = {"Très bien", "Bien", "Mal"};

    public MainJTableFrameCustom() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(600, 140);

        //Données de notre tableau
        Object[][] data = {
                {"Cysboy", "6boy", comboData[0], new Boolean(true)},
                {"BZHHydde", "BZH", comboData[0], new Boolean(false)},
                {"IamBow", "BoW", comboData[0], new Boolean(false)},
                {"FunMan", "Year", comboData[0], new Boolean(true)}
        };

        String title[] = {"Pseudo", "Age", "Taille", "OK ?"};

        //Combo à utiliser
        JComboBox combo = new JComboBox(comboData);

        this.tableau = new JTable(data, title);
        this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
        this.tableau.getColumn("Age").setCellEditor(new CellButtonEditor(new JCheckBox()));

        this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
        this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainJTableFrameCustom fen = new MainJTableFrameCustom();
        fen.setVisible(true);
    }

    //CTRL + SHIFT + O pour générer les imports
    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
            //On écrit dans le bouton ce que contient la cellule
            setText((value != null) ? value.toString() : "");
            //On retourne notre bouton
            return this;
        }
    }

}
