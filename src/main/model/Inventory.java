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
        return true;
    }

    // REQUIRES: a product
    // MODIFIES: this
    // EFFECTS: delete product from inventory and return true;
    //          return false if not found and no p is removed from inventory
    public boolean removeProduct(Product product) {
        for (Product p : inventory) {
            if (p == product) {
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
