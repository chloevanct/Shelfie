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

    // REQUIRES: a product
    // EFFECTS: returns true if inventory has p
    public boolean hasProduct(Product p) {
        return inventory.contains(p);
    }

    // EFFECTS: returns number of products in inventory
    public int getTotal() {
        return inventory.size();
    }

    // REQUIRES: int i >= 0 and inventory of size i - 1
    // EFFECTS: returns the product at index i
    public Product getProductByIndex(int i) {
        return inventory.get(i);
    }

    // REQUIRES: int
    // EFFECTS: returns the product by unique id or null if not found
    public Product getProductByID(int i) {
        for (Product p: inventory) {
            if (i == p.getID()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String inventoryStr = "Your Inventory List: ";
        for (Product p : inventory) {
            inventoryStr = inventoryStr + "\n" + p.toString();
        }
        return inventoryStr;
    }
}
