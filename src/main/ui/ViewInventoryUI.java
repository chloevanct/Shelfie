package ui;

import model.Inventory;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainMenuUI.inventory;


public class ViewInventoryUI extends JFrame implements ActionListener {

    public ViewInventoryUI(Inventory inventory) {
        super("View Inventory");
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        String[] columnNames = {"Product Id",
                "Product Name", "Product Brand", "Product Type",
                "PeriodAfterOpening (Months)",
                "Expiry Date"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(tableModel);
//        table.setPreferredSize(new Dimension(500, 500));
        table.setPreferredScrollableViewportSize(new Dimension(500, 10));
        table.setFillsViewportHeight(true);


        for (Product p : inventory.getProducts()) {
            Object[] data = new Object[]{
                    p.getID(),
                    p.getName(),
                    p.getBrand(),
                    p.getType(),
                    p.getPeriodAfterOpening(),
                    p.getExpDate(),
            };

            DefaultTableModel model = (DefaultTableModel)  table.getModel();
            model.addRow(data);
        }

        add(table);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
