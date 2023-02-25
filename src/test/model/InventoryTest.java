package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {

    private Inventory testInventory;

    @BeforeEach
    void runBefore() {
        testInventory = new Inventory();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testInventory.getTotal());
    }

    @Test
    void testAddProductOnce() {
        Product p = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        assertTrue(testInventory.addProduct(p));
        assertEquals(1, testInventory.getTotal());
        assertEquals(p, testInventory.getProduct(0));
    }

    @Test
    void testAddProductTwice() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProduct(0));
        assertEquals(p2, testInventory.getProduct(1));
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

    // EFFECTS: returns number of products in inventory
    public int getTotal() {
        return inventory.size();
    }


}
