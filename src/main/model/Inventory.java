package model;

import java.util.ArrayList;


// Represents an inventory of products
public class Inventory {

    private ArrayList<Product> inventory;

    // EFFECTS: constructs Inventory as an empty inventory
    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    // REQUIRES: a product
    // MODIFIES: this
    // EFFECTS: adds p to end of the list and returns true
    public boolean addProduct(Product p) {
        inventory.add(p);
        return true;  // stub - why do we add boolean, to confirm that it's working? (like in lab)
    }

    // REQUIRES: a product name and expiry date
    // MODIFIES: this
    // EFFECTS: delete given product from inventory and produce true
    //          return false if not found
    public boolean removeProduct(String name, String expDate) {
        for (Product p : inventory) {
            if ((name == p.getName()) && expDate == p.getExpDate()) {
                inventory.remove(p);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: inventory is not empty
    // EFFECTS: returns number of products in inventory
    public int getTotal() {
        return inventory.size();
    }


}
