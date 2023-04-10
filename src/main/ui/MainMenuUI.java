package ui;

import model.Event;
import model.EventLog;
import model.Inventory;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;


// This class references code from this repo:
// Link: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
// Main page GUI for Shelfie Application
public class MainMenuUI extends JFrame implements ActionListener {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    protected static Inventory inventory;

    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);
    private static final String JSON_STORE = "./data/inventory.json";

    private JButton saveButton;
    private JButton loadButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton viewButton;
    private JLabel header;


    // MODIFIES: GUI
    // EFFECTS: constructor sets up Main Menu, including buttons for save, load, view inventory,
    //          add and remove product
    public MainMenuUI() throws FileNotFoundException {

        inventory = new Inventory();

        setUpHeader();

        setUpButtons();

        JFrame mainPage = new JFrame("Main Menu");

        mainPage.addWindowListener(windowClosing);

        mainPage.setTitle("Shelfie");
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setResizable(false);
        mainPage.setSize(WIDTH, HEIGHT);
        mainPage.getContentPane().setBackground(Color.white);
        mainPage.setLayout(null);
        mainPage.add(header);
        mainPage.add(saveButton);
        mainPage.add(loadButton);
        mainPage.add(viewButton);
        mainPage.add(addButton);
        mainPage.add(removeButton);
        mainPage.setVisible(true);
    }

    // EFFECTS: actionEvent for this frame
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void setUpButtons() {
        setUpSaveButton();
        setUpLoadButton();
        setUpViewButton();
        setUpAddButton();
        setUpRemoveButton();
    }

    // MODIFIES: this
    // EFFECTS: sets up save button
    private void setUpSaveButton() {
        saveButton = new JButton("Save Current Inventory");
        saveButton.setFocusable(false);
        saveButton.setBounds(500, 600, 200, 50);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(inventory);
                    jsonWriter.close();
                    //System.out.println("Saved " + "to " + JSON_STORE);
                } catch (FileNotFoundException ee) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: sets up load button
    private void setUpLoadButton() {
        loadButton = new JButton("Load Previous Inventory");
        loadButton.setFocusable(false);
        loadButton.setBounds(500, 550, 200, 50);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inventory = jsonReader.read();
                    //System.out.println("Loaded " + "from " + JSON_STORE);
                } catch (IOException ee) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: sets up view button
    private void setUpViewButton() {
        viewButton = new JButton("View");
        viewButton.setFocusable(false);
        viewButton.setBounds(250, 500, 450, 50);
        viewButton.addActionListener(this);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewInventoryUI(inventory);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: sets up add button
    private void setUpAddButton() {
        addButton = new JButton("Add Product");
        addButton.setFocusable(false);
        addButton.setBounds(250, 600, 200, 50);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: sets up remove button
    private void setUpRemoveButton() {
        removeButton = new JButton("Remove");
        removeButton.setText("Remove Product");
        removeButton.setFocusable(false);
        removeButton.setBounds(250, 550, 200, 50);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveProductUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: sets up header with shelfie image
    private void setUpHeader() {
        ImageIcon logo = new ImageIcon("./data/images/shelfielogo.png");
        header = new JLabel();
        header.setIcon(logo);
        header.setBackground(Color.white);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.TOP);
        header.setBounds(250, 0, 500, 500);
        header.setOpaque(true);
    }

    private WindowAdapter windowClosing = new WindowAdapter() {

        public void windowClosing(WindowEvent w) {
            for (model.Event e : model.EventLog.getInstance()) {
                System.out.println(e);
            }

            System.exit(0);
        }
    };
}






