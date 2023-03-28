package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainMenuUI.inventory;

// Remove product GUI for Shelfie Application
public class RemoveProductUI extends JFrame implements ActionListener {

    private JTextField setId;

    // MODIFIES: GUI
    // EFFECTS: constructs a pop-up menu for removing products
    public RemoveProductUI() {

        super("Remove Product");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
        JButton btn = new JButton("Remove Product");
        btn.setActionCommand("removeProduct");
        btn.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        setId = new JTextField(5);
        setId.setText("Product Id");

        panel.add(setId);
        panel.add(btn);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: inventory
    // EFFECTS: Removes given product with ID from inventory after "Remove Product" button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("removeProduct")) {
            Integer id = Integer.parseInt(setId.getText());
            inventory.removeProduct(inventory.getProductByID(id));
            System.out.println("Product with Id: " + String.valueOf(id) + " removed");
        }

    }
}
