package ui;

import model.Inventory;
import model.Product;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.time.LocalDate.of;

// This class references code from this repo:
// Link: https://github.com/stleary/JSON-java
// Shelfie application
public class ShelfieApp {
    private static final String JSON_STORE = "./data/inventory.json";
    private Inventory inventory;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the shelfie application
    public ShelfieApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        //inventory = new Inventory();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
        System.out.println("\tu -> update expiry date to earliest date, "
                + "i've just opened this product for the first time!");
        System.out.println("\tr -> remove a product from inventory");
        System.out.println("\ts -> save inventory to file");
        System.out.println("\tl -> load inventory from file");
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
        } else if (command.equals("s")) {
            saveInventory();
        } else if (command.equals("l")) {
            loadInventory();
        } else {
            System.out.println("Try again... selection not valid");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes chosen existing product from inventory
    private void doRemoveProduct() {
        if (inventory.getTotal() == 0) {
            System.out.println("There is nothing to remove...");
        } else {
            Product selected = selectProduct();
            inventory.removeProduct(selected);
        }
    }

    // MODIFIES: this
    // EFFECTS: updates expDate to the earliest LocalDate between manfExpDate or updateExpDateOnceOpened
    private void doUpdateExpDate() {

        if (inventory.getTotal() == 0) {
            System.out.println("There is nothing to update...");
        } else {
            Product selected = selectProduct();
            LocalDate manfExpDate = selected.getExpDate();
            selected.updateExpDateOnceOpened();
            LocalDate updatedExpDate = selected.getExpDate();
            if (manfExpDate.isBefore(updatedExpDate)) {
                selected.setExpDate(manfExpDate);
                System.out.println("Expiry date remains unchanged");
            } else {
                selected.setExpDate(updatedExpDate);
                System.out.println("Expiry date updated to new date: today's date + period after opening");
            }
        }
    }

    // EFFECTS: prints list of all products in inventory; prints empty if empty
    private void doViewInventory() {

        if (inventory.getTotal() == 0) {
            System.out.println("Your Inventory is Empty");
        } else {
            String inventoryStr = inventory.toString();
            System.out.println(inventoryStr);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds p to inventory
    @SuppressWarnings("methodlength")
    private void doAddProduct() {
        System.out.print("Enter the name of product: ");
        String name = input.next();
        name = name.toLowerCase();
        System.out.print("Enter the brand of product: ");
        String brand = input.next();
        brand = brand.toLowerCase();
        System.out.print("Enter the type of product: ");
        String type = input.next();
        type = type.toLowerCase();
        System.out.print("Enter the period after opening (num of months): ");
        String periodAfterOpeningStr = input.next();
        int periodAfterOpening = Integer.parseInt(periodAfterOpeningStr);
        System.out.print("Enter the expiry year: ");
        String yearStr = input.next();
        int year = Integer.parseInt(yearStr);
        System.out.print("Enter the expiry month (num): ");
        String monthStr = input.next();
        int month = Integer.parseInt(monthStr);
        System.out.print("Enter the expiry day: ");
        String dayStr = input.next();
        int day = Integer.parseInt(dayStr);
        LocalDate expDate = of(year, month, day);
        Product p = new Product(name, brand, type, periodAfterOpening, expDate);
        inventory.addProduct(p);
    }

    // EFFECTS: prompts user to select existing product and returns it
    private Product selectProduct() {
        String selection = " ";
        int chosenID = -1;

        while (selection.equals(" ")) {
            doViewInventory();
            System.out.println("Type unique id to select product ");
            selection = input.next();
            chosenID = Integer.parseInt(selection);
        }

        Product selected = inventory.getProductByID(chosenID);
        if (selected == null) {
            System.out.println("Try again!");
            selectProduct();
        }
        return selected;
    }

    // EFFECTS: saves the inventory to file
    private void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.write(inventory);
            jsonWriter.close();
            System.out.println("Saved " + "to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

    // MODIFIES: this
    // EFFECTS: loads inventory from file
    private void loadInventory() {
        try {
            inventory = jsonReader.read();
            System.out.println("Loaded " + "from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}


