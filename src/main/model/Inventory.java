package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents an inventory of products
public class Inventory implements Writable {

    private String name;
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
        EventLog.getInstance().logEvent(new Event("product added to inventory"));
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
                EventLog.getInstance().logEvent(new Event("product removed from inventory"));
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
        for (Product p : inventory) {
            if (i == p.getID()) {
                return p;
            }
        }
        return null;
    }

    // EFFECTS: returns list of products in this inventory
    public List<Product> getProducts() {
        EventLog.getInstance().logEvent(new Event("viewed inventory"));
        return inventory;
    }

    @Override
    // EFFECTS: returns a string representation of inventory
    public String toString() {
        String inventoryStr = "Your Inventory List: ";
        for (Product p : inventory) {
            inventoryStr = inventoryStr + "\n" + p.toString();
        }
        return inventoryStr;
    }

    @Override
    // EFFECTS: returns inventory as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("inventory", productToJson());
        return json;
    }

    // EFFECTS: returns products in this inventory as a JSON array
    private JSONArray productToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Product p : inventory) {
            jsonArray.put(p.toJson());
        }
        return jsonArray;
    }
}
