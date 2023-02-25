package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(p, testInventory.getProductByIndex(0));
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
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
    }

    @Test
    void testRemoveProductFirstOne() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
        assertTrue(testInventory.removeProduct(p1));
        assertEquals(1, testInventory.getTotal());
        assertEquals(p2, testInventory.getProductByIndex(0));
    }

    @Test
    void testRemoveProductSecondOne() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
        assertTrue(testInventory.removeProduct(p2));
        assertEquals(1, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
    }

    @Test
    void testRemoveProductTwice() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertTrue(testInventory.removeProduct(p2));
        assertTrue(testInventory.removeProduct(p1));
        assertEquals(0, testInventory.getTotal());
    }

    @Test
    void testRemoveProductDidNotRemoveProduct() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        Product p3 = new Product("Hand Salve", "Kiehl's", "Hand Cream",
                6, LocalDate.of(2023, 7, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertFalse(testInventory.removeProduct(p3));
        assertEquals(2, testInventory.getTotal());
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
    }

    @Test
    void testGetTotalEmpty() {
        assertEquals(0, testInventory.getTotal());
    }

    @Test
    void testGetTotalNotEmpty() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
    }

    @Test
    void testHasProductTrue() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.hasProduct(p1));
    }

    @Test
    void testHasProductFalse() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertFalse(testInventory.hasProduct(p2));
    }

    @Test
    void testGetProductByIndex() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
    }

    @Test
    void testGetProductByIDFound() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p2, testInventory.getProductByID(p2.getID()));
    }

    @Test
    void testGetProductByIDNotFound() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(null, testInventory.getProductByID(7));

    }

    @Test
    void testToString() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                8, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertTrue(testInventory.toString().contains("Your Inventory List: "));
        assertTrue(testInventory.toString().contains("name = Eau Thermale"));
        assertTrue(testInventory.toString().contains("brand = Uriage"));
        assertTrue(testInventory.toString().contains("type = Lip Balm"));
        assertTrue(testInventory.toString().contains("period after opening = 6"));
        assertTrue(testInventory.toString().contains("exp date = 2023-06-28"));
        assertTrue(testInventory.toString().contains("name = April Cotton"));
        assertTrue(testInventory.toString().contains("brand = W.Dressroom"));
        assertTrue(testInventory.toString().contains("type = Hand Cream"));
        assertTrue(testInventory.toString().contains("period after opening = 8"));
        assertTrue(testInventory.toString().contains("exp date = 2023-11-12"));
    }

}
