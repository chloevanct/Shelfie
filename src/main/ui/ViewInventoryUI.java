package ui;

import model.Inventory;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInventoryUI extends JFrame implements ActionListener {

    // MODIFIES: GUI
    // EFFECTS: constructs a pop-up menu for viewing products
    public ViewInventoryUI(Inventory inventory) {
        super("View Inventory");
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        String[] columnNames = {"Product Id",
                "Product Name", "Product Brand", "Product Type", "PeriodAfterOpening (Months)",
                "Expiry Date"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 250));
        table.setFillsViewportHeight(true);

        for (Product p : inventory.getProducts()) {
            Object[] data = new Object[]{
                    p.getID(), p.getName(),
                    p.getBrand(), p.getType(),
                    p.getPeriodAfterOpening(),
                    p.getExpDate(),
            };

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(data);
        }

        add(new JScrollPane(table));
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
