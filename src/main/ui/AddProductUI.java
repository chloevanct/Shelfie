package ui;

import model.Product;

import static java.time.LocalDate.of;
import static ui.MainMenuUI.inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

//public class AddProductUI extends JFrame {

//    private static final int WIDTH = 1000;
//    private static final int HEIGHT = 1000;
//
//    public AddProductUI() {
//
//        JFrame mainPage = new JFrame("Add Product");
//        mainPage.setTitle("Add Product");
//        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainPage.setResizable(false);
//        mainPage.setSize(WIDTH, HEIGHT);
//        mainPage.getContentPane().setBackground(Color.white);
//        mainPage.setLayout(null);
//
//    }


public class AddProductUI extends JFrame implements ActionListener {

    private JTextField setProductName;
    private JTextField setProductBrand;
    private JTextField setProductType;
    private JTextField setPeriodAfterOpening;
    private JTextField setExpDay;
    private JTextField setExpMonth;
    private JTextField setExpYear;

    // MODIFIES: GUI
    // EFFECTS: constructs a pop-up menu for adding sets
    public AddProductUI() {
        super("Add Product");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
        JButton btn = new JButton("Add Product");
        btn.setActionCommand("addProduct");
        btn.addActionListener(this);
        setProductName = new JTextField(5);
        setProductBrand = new JTextField(5);
        setProductType = new JTextField(5);
        setPeriodAfterOpening = new JTextField(5);
        setExpDay = new JTextField(5);
        setExpMonth = new JTextField(5);
        setExpYear = new JTextField(5);
        add(setProductName);
        add(setProductBrand);
        add(setProductType);
        add(setPeriodAfterOpening);
        add(setExpDay);
        add(setExpMonth);
        add(setExpYear);
        add(btn);
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
}


