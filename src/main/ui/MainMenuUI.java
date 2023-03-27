package ui;

import javax.swing.*;
import java.awt.*;

// This class references code from this repo:
// Link: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
// Main page GUI for Shelfie Application

public class MainMenuUI extends JFrame {

    // Constructor sets up buttons for save, load, view inventory, add and remove product
    public MainMenuUI() {

        ImageIcon logo = new ImageIcon("./data/images/shelfielogo.png");

        JLabel header = new JLabel();
        header.setIcon(logo);
        header.setBackground(Color.white);
        header.setOpaque(true);

        JFrame mainPage = new JFrame("Main Menu");
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setBackground(Color.white);
        header.setPreferredSize(new Dimension(500,500));
        mainPage.getContentPane().add(header, BorderLayout.CENTER);
        mainPage.add(header);

        mainPage.pack();
        mainPage.setVisible(true);
    }

}
