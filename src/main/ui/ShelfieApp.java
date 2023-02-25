package ui;

import model.Inventory;
import model.Product;

import java.util.Scanner;

// Shelfie application
public class ShelfieApp {
    private Product product;
    private Inventory inventory;
    private Scanner input;

    // EFFECTS: runs the shelfie application
    public ShelfieApp() {
        runShelfie();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runShelfie() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        while (keepGoing) {
            displayOptions();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nSee you later!");
    }


    // MODIFIES: this
    // EFFECTS: initializes inventory
    private void initialize() {
        inventory = new Inventory();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays all options to user
    private void displayOptions() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add product");
        System.out.println("\tv -> view inventory");
        System.out.println("\tu -> update expiry date of a product");
        System.out.println("\tr -> remove a product from inventory");
        System.out.println("\te -> remove all expired products from inventory");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes command from user
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAddProduct();
        } else if (command.equals("v")) {
            doViewInventory();
        } else if (command.equals("u")) {
            doUpdateExpDate();
        } else if (command.equals("r")) {
            doRemoveProduct();
        } else if (command.equals("e")) {
            doRemoveAllExpProducts();
        } else {
            System.out.println("Try again... selection not valid");
        }
    }

    private void doRemoveAllExpProducts() {
    }

    private void doRemoveProduct() {
    }

    private void doUpdateExpDate() {
    }

    private void doViewInventory() {
    }

    private void doAddProduct() {
    }


}
