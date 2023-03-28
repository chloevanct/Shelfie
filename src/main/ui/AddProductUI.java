package ui;

import model.Product;

import static java.time.LocalDate.of;
import static ui.MainMenuUI.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddProductUI extends JFrame implements ActionListener {

    private JTextField setProductName;
    private JTextField setProductBrand;
    private JTextField setProductType;
    private JTextField setPeriodAfterOpening;
    private JTextField setExpDay;
    private JTextField setExpMonth;
    private JTextField setExpYear;

    // MODIFIES: GUI
    // EFFECTS: constructs a pop-up menu for adding products
    public AddProductUI() {
        super("Add Product");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
        JButton btn = new JButton("Add Product");
        btn.setActionCommand("addProduct");
        btn.addActionListener(this);

        setAddProductTextBoxes();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(setProductName);
        panel.add(setProductBrand);
        panel.add(setProductType);
        panel.add(setPeriodAfterOpening);
        panel.add(setExpDay);
        panel.add(setExpMonth);
        panel.add(setExpYear);
        panel.add(btn);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: userDeck
    // EFFECTS: Adds a set of the given title to the userDeck after the "Add Set" button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addProduct")) {
            String name = setProductName.getText();
            String brand = setProductBrand.getText();
            String type = setProductType.getText();
            Integer periodAfterOpening = Integer.parseInt(setPeriodAfterOpening.getText());
            Integer expDay = Integer.parseInt(setExpDay.getText());
            Integer expMonth = Integer.parseInt(setExpMonth.getText());
            Integer expYear = Integer.parseInt(setExpYear.getText());
            LocalDate expDate = of(expYear, expMonth, expDay);
            inventory.addProduct(new Product(name, brand, type, periodAfterOpening, expDate));
            for (Product p : inventory.getProducts()) {
                System.out.println(p.getName());
            }
        }
    }

    private void setAddProductTextBoxes() {

        setProductName = new JTextField(5);
        setProductName.setText("Product Name");

        setProductBrand = new JTextField(5);
        setProductBrand.setText("Product Brand");

        setProductType = new JTextField(5);
        setProductType.setText("Product Type");

        setPeriodAfterOpening = new JTextField(5);
        setPeriodAfterOpening.setText("PeriodAfterOpening (Months)");

        setExpDay = new JTextField(5);
        setExpDay.setText("Product Exp Day");

        setExpMonth = new JTextField(5);
        setExpMonth.setText("Product Exp Month");

        setExpYear = new JTextField(5);
        setExpYear.setText("Product Exp Year");

    }
}


