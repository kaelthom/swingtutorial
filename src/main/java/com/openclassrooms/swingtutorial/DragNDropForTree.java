package com.openclassrooms.swingtutorial;

import com.openclassrooms.swingtutorial.transferhandlers.MyTransferHandler;
import com.openclassrooms.swingtutorial.transferhandlers.TreeTransferHandler;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragNDropForTree extends JFrame {
    JTree tree;

    public DragNDropForTree() {
        setTitle("Drag'n Drop avec un JLabel !");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(1, 1));
        pan.setBackground(Color.white);

        JLabel srcLib = new JLabel("Source de drag : ", JLabel.RIGHT);
        JLabel src = new JLabel("Noeud 1");

        //------------------------------------------------------
        //On utilise notre nouvel objet MyTransferHandle
        src.setTransferHandler(new MyTransferHandler());
        src.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                JComponent lab = (JComponent) e.getSource();
                TransferHandler handle = lab.getTransferHandler();
                handle.exportAsDrag(lab, e, TransferHandler.MOVE);
            }
        });
        //------------------------------------------------------

        JLabel destLib = new JLabel("Destination de drag : ", JLabel.RIGHT);
        JTextField dest = new JTextField();

        dest.setDragEnabled(true);
        tree = new JTree(getModel());
        tree.setDragEnabled(true);
        tree.setTransferHandler(new TreeTransferHandler(tree));

        pan.add(src);

        pan.add(new JScrollPane(tree));

        //Pour le choix des actions
        JComboBox combo = new JComboBox();
        combo.addItem("USE_SELECTION");
        combo.addItem("ON");
        combo.addItem("INSERT");
        combo.addItem("ON_OR_INSERT");

        combo.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent event) {
                String value = event.getItem().toString();

                if (value.equals("USE_SELECTION"))
                    tree.setDropMode(DropMode.USE_SELECTION);

                if (value.equals("ON"))
                    tree.setDropMode(DropMode.ON);

                if (value.equals("INSERT"))
                    tree.setDropMode(DropMode.INSERT);

                if (value.equals("ON_OR_INSERT"))
                    tree.setDropMode(DropMode.ON_OR_INSERT);

            }
        });

        add(pan, BorderLayout.CENTER);
        add(combo, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DragNDropForTree();
    }

    private TreeModel getModel() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("SDZ");

        DefaultMutableTreeNode forum = new DefaultMutableTreeNode("Forum");
        forum.add(new DefaultMutableTreeNode("C++"));
        forum.add(new DefaultMutableTreeNode("Java"));
        forum.add(new DefaultMutableTreeNode("PHP"));

        DefaultMutableTreeNode tuto = new DefaultMutableTreeNode("Tutoriel");
        tuto.add(new DefaultMutableTreeNode("Tutoriel"));
        tuto.add(new DefaultMutableTreeNode("Programmation"));
        tuto.add(new DefaultMutableTreeNode("Mapping"));

        root.add(tuto);
        root.add(forum);

        return new DefaultTreeModel(root);
    }
}
