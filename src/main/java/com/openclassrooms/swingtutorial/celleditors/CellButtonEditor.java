package com.openclassrooms.swingtutorial.celleditors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CTRL + SHIFT + O pour générer les imports
public class CellButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private boolean isPushed;
    private ButtonListener bListener = new ButtonListener();

    //Constructeur avec une CheckBox
    public CellButtonEditor(JCheckBox checkBox) {
        //Par défaut, ce type d'objet travaille avec un JCheckBox
        super(checkBox);
        //On crée à nouveau un bouton
        button = new JButton();
        button.setOpaque(true);
        //On lui attribue un listener
        button.addActionListener(bListener);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //On précise le numéro de ligne à notre listener
        bListener.setRow(row);
        //Idem pour le numéro de colonne
        bListener.setColumn(column);
        //On passe aussi le tableau en paramètre pour des actions potentielles
        bListener.setTable(table);

        //On réaffecte le libellé au bouton
        button.setText((value == null) ? "" : value.toString());
        //On renvoie le bouton
        return button;
    }

    //Notre listener pour le bouton
    class ButtonListener implements ActionListener {
        private int column, row;
        private JTable table;
        private int nbre = 0;

        public void setColumn(int col) {
            this.column = col;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setTable(JTable table) {
            this.table = table;
        }

        public void actionPerformed(ActionEvent event) {
            //On affiche un message, mais vous pourriez effectuer les traitements que vous voulez
            System.out.println("coucou du bouton : " + ((JButton) event.getSource()).getText());
            //On affecte un nouveau libellé à une autre cellule de la ligne
            table.setValueAt("New Value " + (++nbre), this.row, (this.column - 1));
        }
    }
}
